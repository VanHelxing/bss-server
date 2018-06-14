package cn.zhimadi.bss.security.web;

import cn.zhimadi.bss.common.web.controller.BaseController;
import cn.zhimadi.bss.security.dto.ResourceDTO;
import cn.zhimadi.bss.security.entity.Resource;
import cn.zhimadi.bss.security.service.ResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
