package cn.zhimadi.bss.security.web;

import cn.zhimadi.bss.common.exception.CustomException;
import cn.zhimadi.bss.common.pojo.ResponseData;
import cn.zhimadi.bss.common.util.StringUtils;
import cn.zhimadi.bss.common.web.controller.BaseController;
import cn.zhimadi.bss.security.dto.ResourceDTO;
import cn.zhimadi.bss.security.entity.Resource;
import cn.zhimadi.bss.security.service.ResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("security/resource")
public class ResourceController extends BaseController {

    @Autowired
    private ResourceService resourceService;


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
        addEntityParam(Resource.class, model);
        return getListPagePath(Resource.class, "system");
    }


    /**
     * 查询数据列表
     *
     * @return the Object
     * @author : yangjunqing / 2018-06-13
     */
    @PostMapping("list")
    @ResponseBody
    public Object query(){
        List<Resource> resources = resourceService.findAll();
        return convert(resources);
    }


    /**
     * Entity转DTO
     *
     * @param resources the resources
     * @return the list
     * @author : yangjunqing / 2018-06-13
     */
    private List<ResourceDTO> convert(List<Resource> resources){
        List<ResourceDTO> dtos = new ArrayList<>();
        for (Resource resource : resources){
            ResourceDTO dto = new ResourceDTO();
            BeanUtils.copyProperties(resource, dto);
            dtos.add(dto);
        }
        return dtos;
    }


    /**
     * 新增
     * @param pid
     * @param name
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public ResponseData add(@RequestParam("pid")String pid, @RequestParam("name")String name){
        if (StringUtils.isEmpty(pid) || StringUtils.isEmpty(name)){
            throw new CustomException("父编号或者资源名称不能为空!");
        }

        Resource resource= new Resource();
        resource.setName(name);
        resource.setPId(pid);
        resource = resourceService.save(resource);
        return ResponseData.ok(resource);
    }


    /**
     * 更新
     * @param id
     * @param name
     * @return
     */
    @PostMapping("update")
    @ResponseBody
    public ResponseData update(@RequestParam("id")String id, @RequestParam("name")String name){
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(name)){
            throw new CustomException("编号或者资源名称不能为空!");
        }

        Resource resource = resourceService.findById(id);
        resource.setName(name);
        resourceService.save(resource);
        return ResponseData.ok();
    }


    /**
     * 删除
     *
     * @param id the id
     * @return the response data
     * @author : yangjunqing / 2018-06-14
     */
    @PostMapping("delete")
    @ResponseBody
    public ResponseData delete(String id){
        //根据id数组查询对象
        Resource resource = resourceService.findById(id);
        //删除对象
        resourceService.delete(resource);
        return ResponseData.ok();
    }

}
