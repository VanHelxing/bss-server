package ${service_impl_package};

import cn.zhimadi.bss.common.dao.BaseDao;
import cn.zhimadi.bss.common.service.BaseServiceImpl;
import ${dao_package}.${entity_name}Dao;
import ${entity_package}.${entity_name};
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * ${entity_description}接口实现类
 * @author : ${author_name} / ${author_name}@zhimadi.cn
 * @version : 1.0
 */
@Service
public class ${entity_name}ServiceImpl extends BaseServiceImpl<${entity_name}> implements ${entity_name}Service {

    @Autowired
    private ${entity_name}Dao ${lower_entity_name}Dao;


    @Override
    protected BaseDao<${entity_name}> getDao() {
        return ${lower_entity_name}Dao;
    }
}
