package cn.zhimadi.bss.dict.web;

import cn.zhimadi.bss.common.constant.Constants;
import cn.zhimadi.bss.common.exception.CustomException;
import cn.zhimadi.bss.common.pojo.ResponseData;
import cn.zhimadi.bss.common.search.DataTable;
import cn.zhimadi.bss.common.search.SearchResponse;
import cn.zhimadi.bss.common.util.StringUtils;
import cn.zhimadi.bss.common.web.controller.BaseController;
import cn.zhimadi.bss.dict.dto.DictDTO;
import cn.zhimadi.bss.dict.dto.DictDetailDTO;
import cn.zhimadi.bss.dict.entity.Dict;
import cn.zhimadi.bss.dict.entity.DictDetail;
import cn.zhimadi.bss.dict.service.DictDetailService;
import cn.zhimadi.bss.dict.service.DictService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典Controller
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Controller
@RequestMapping("dict/dict")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;
    @Autowired
    private DictDetailService dictDetailService;


    /**
     * 请求数据列表界面
     *
     * @param model the model
     * @return the string
     * @author : yangjunqing / 2018-06-13
     */
    @GetMapping
    public String list(Model model){
        //设置页面实体参数(路径，消息，权限前缀)
        addEntityParam(Dict.class, model);
        return getListPagePath(Dict.class, "system");
    }


    /**
     * 查询数据列表
     *
     * @param dataTable the data table
     * @return the map
     * @author : yangjunqing / 2018-06-13
     */
    @PostMapping("list")
    @ResponseBody
    public Map<String, Object> query(DataTable dataTable){
        Map<String, Object> map = new HashMap<>();
        //根据dataTable查询数据记录
        SearchResponse<Dict> searchResponse = dictService.findAll(dataTable, Dict.class);
        map.put(PARAM_DRAW, dataTable.getDraw());
        map.put(PARAM_RECORDS_TOTAL, searchResponse.getRecordsTotal());
        map.put(PARAM_RECORDS_FILTERED, searchResponse.getRecordsFiltered());
        map.put(PARAM_DATA, convert(searchResponse.getData()));
        return map;
    }


    /**
     * Entity转DTO
     *
     * @param dicts the dicts
     * @return the list
     * @author : yangjunqing / 2018-06-13
     */
    private List<DictDTO> convert(List<Dict> dicts){
        List<DictDTO> dtos = new ArrayList<>();
        for (Dict dict : dicts){
            DictDTO dto = new DictDTO();
            BeanUtils.copyProperties(dict, dto);
            dtos.add(dto);
        }
        return dtos;
    }


    /**
     *  新增
     *
     * @param model the model
     * @return the string
     * @author : yangjunqing / 2018-06-14
     */
    @GetMapping("create")
    public String create(Model model){
        DictDTO dto = new DictDTO();

        //设置dto对象到页面
        model.addAttribute(PARAM_DTO, dto);
        //设置页面实体参数(路径，消息，权限前缀)
        addEntityParam(Dict.class, model);
        return getEditPagePath(Dict.class, "system");
    }


    /**
     * 更新
     *
     * @param model the model
     * @param id    the id
     * @return the string
     * @author : yangjunqing / 2018-06-14
     */
    @GetMapping("update")
    public String update(Model model, @RequestParam("id") String id){
        if (StringUtils.isEmpty(id)){
            throw new CustomException("字典编号不能为空!");
        }

        DictDTO dto = new DictDTO();
        Dict dict = dictService.findById(id);
        BeanUtils.copyProperties(dict, dto);

        //设置dto对象到页面
        model.addAttribute(PARAM_DTO, dto);
        //设置页面实体参数(路径，消息，权限前缀)
        addEntityParam(Dict.class, model);
        return getEditPagePath(Dict.class, "system");
    }


    /**
     * 删除
     *
     * @param ids the ids
     * @return the response data
     * @author : yangjunqing / 2018-06-14
     */
    @PostMapping("delete")
    @ResponseBody
    public ResponseData delete(String ids){
        //根据id数组查询对象列表
        Iterable<Dict> list = dictService.findAll(StringUtils.splitToString(ids, ","));
        //删除对象列表
        dictService.deleteInBatch(list);
        return ResponseData.ok();
    }


    /**
     * 保存
     *
     *
     * @param dto the dto
     * @return the response data
     * @author : yangjunqing / 2018-06-14
     */
    @PostMapping("save")
    @ResponseBody
    public ResponseData save(DictDTO dto){
        Dict dict = new Dict();
        BeanUtils.copyProperties(dto, dict);

        if (StringUtils.isEmpty(dict.getId())){
            Dict temp = dictService.findByDictType(dict.getDictType());
            if (temp != null){
                throw new CustomException("字典类型已存在!");
            }
        }
        dictService.save(dict);

        return ResponseData.ok();
    }


    /**
     * 明细请求数据列表界面
     *
     * @param model the model
     * @return the string
     * @author : yangjunqing / 2018-06-13
     */
    @GetMapping("detail")
    public String detail(Model model, @RequestParam("id") String id){

        Dict dict = dictService.findById(id);
        List<DictDetail> details = dictDetailService.findByDictType(dict.getDictType());
        List<DictDetailDTO> dtos = convertDetail(details);

        //设置数据到页面
        model.addAttribute("dtos", dtos);
        //设置字典类型
        model.addAttribute("dictType", dict.getDictType());
        //设置页面实体参数(路径，消息，权限前缀)
        addEntityParam(Dict.class, model);
        return getDetailPagePath(Dict.class, "system");
    }


    /**
     * 明细Entity转DTO
     *
     * @param dictDetails the dicts
     * @return the list
     * @author : yangjunqing / 2018-06-13
     */
    private List<DictDetailDTO> convertDetail(List<DictDetail> dictDetails){
        List<DictDetailDTO> dtos = new ArrayList<>();
        for (DictDetail dictDetail : dictDetails){
            DictDetailDTO dto = new DictDetailDTO();
            BeanUtils.copyProperties(dictDetail, dto);
            dtos.add(dto);
        }
        return dtos;
    }


    /**
     *  明细新增
     *
     * @param model the model
     * @return the string
     * @author : yangjunqing / 2018-06-14
     */
    @GetMapping("createDetail")
    public String createDetail(Model model){
        DictDetailDTO dto = new DictDetailDTO();

        //新增标记
        dto.setModifyRecord(Constants.DTO_ADD);
        //设置dto对象到页面
        model.addAttribute(PARAM_DTO, dto);
        //设置页面实体参数(路径，消息，权限前缀)
        addEntityParam(Dict.class, model);
        return getEditDetailPagePath(Dict.class, "system");
    }


    /**
     * 明细更新
     *
     * @param model the model
     * @param id    the id
     * @return the string
     * @author : yangjunqing / 2018-06-14
     */
    @GetMapping("updateDetail")
    public String updateDetail(Model model, @RequestParam("id") String id){
        if (StringUtils.isEmpty(id)){
            throw new CustomException("字典数据编号不能为空!");
        }

        DictDetailDTO dto = new DictDetailDTO();
        DictDetail dictDetail = dictDetailService.findById(id);
        BeanUtils.copyProperties(dictDetail, dto);
        //更新标记
        dto.setModifyRecord(Constants.DTO_UPDATE);

        //设置dto对象到页面
        model.addAttribute(PARAM_DTO, dto);
        //设置页面实体参数(路径，消息，权限前缀)
        addEntityParam(Dict.class, model);
        return getEditDetailPagePath(Dict.class, "system");
    }


    /**
     * 明细删除
     *
     * @param ids the ids
     * @return the response data
     * @author : yangjunqing / 2018-06-14
     */
    @PostMapping("deleteDetail")
    @ResponseBody
    public ResponseData deleteDetail(String ids){
        //根据id数组查询对象列表
        Iterable<DictDetail> list = dictDetailService.findAll(StringUtils.splitToString(ids, ","));
        //删除对象列表
        dictDetailService.deleteInBatch(list);
        return ResponseData.ok();
    }


    /**
     * 明细保存
     *
     *
     * @param dto the dto
     * @return the response data
     * @author : yangjunqing / 2018-06-14
     */
    @PostMapping("saveDetail")
    @ResponseBody
    public ResponseData saveDetail(DictDetailDTO dto){
        DictDetail detail = new DictDetail();
        BeanUtils.copyProperties(dto, detail);

        if (StringUtils.isEmpty(detail.getId())){
            DictDetail temp = dictDetailService.findByDictTypeAndNo(detail.getDictType(), detail.getNo());
            if (temp != null){
                throw new CustomException("该字典数据序号已存在!");
            }
        }
        dictDetailService.save(detail);

        return ResponseData.ok();
    }

}
