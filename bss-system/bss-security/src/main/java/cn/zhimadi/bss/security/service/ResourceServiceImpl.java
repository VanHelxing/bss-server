package cn.zhimadi.bss.security.service;

import cn.zhimadi.bss.common.dao.BaseDao;
import cn.zhimadi.bss.common.service.BaseServiceImpl;
import cn.zhimadi.bss.security.dao.ResourceDao;
import cn.zhimadi.bss.security.entity.Resource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 功能菜单接口实现类
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;


    @Override
    protected BaseDao<Resource> getDao() {
        return resourceDao;
    }
}
