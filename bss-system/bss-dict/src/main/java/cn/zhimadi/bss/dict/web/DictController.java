package cn.zhimadi.bss.dict.web;

import cn.zhimadi.bss.common.search.DataTable;
import cn.zhimadi.bss.common.search.SearchResponse;
import cn.zhimadi.bss.common.web.controller.BaseController;
import cn.zhimadi.bss.dict.dto.DictDTO;
import cn.zhimadi.bss.dict.entity.Dict;
import cn.zhimadi.bss.dict.entity.ResourceTree;
import cn.zhimadi.bss.dict.service.DictService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * Dict service
     */
    @Autowired
    private DictService dictService;


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
     *
     * @return
     */
    @PostMapping("tree")
    @ResponseBody
    public Object zTreeTest(){

        List<ResourceTree> trees = new ArrayList<>();
        trees.add(new ResourceTree(1, 0, "公司", "", 1, 0, "", ""));
        trees.add(new ResourceTree(11, 1,"超级管理员", "", 0, 0, "", "mainF"));
        trees.add(new ResourceTree(111, 11, "显示报表", "http://localhost:8080/InspurUser/chart/index.jsp", 0, 0, "", "mainF"));
        trees.add(new ResourceTree(112, 11, "管理用户", "http://localhost:8080/InspurUser/DirectTo?method=toUserManager", 0, 0, "", "mainF"));
        trees.add(new ResourceTree(12, 1, "普通用户", "", 0, 0, "", "mainF"));
        trees.add(new ResourceTree(121, 12, "跳转到Google", "http://www.google.com", 0, 0, "", "mainF"));
        trees.add(new ResourceTree(122, 12, "叶子结点2", "", 0, 0, "", "mainF"));

        return trees;
    }

}
