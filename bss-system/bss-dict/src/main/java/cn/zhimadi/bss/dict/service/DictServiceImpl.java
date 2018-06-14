package cn.zhimadi.bss.dict.service;

import cn.zhimadi.bss.common.dao.BaseDao;
import cn.zhimadi.bss.common.service.BaseServiceImpl;
import cn.zhimadi.bss.dict.dao.DictDao;
import cn.zhimadi.bss.dict.entity.Dict;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 字典信息接口实现类
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService {

    @Autowired
    private DictDao dictDao;


    @Override
    protected BaseDao<Dict> getDao() {
        return dictDao;
    }


    /**
     * Find by dict dictType.
     *
     * @param dictType the dict type
     * @return the dict
     * @author : yangjunqing / 2018-06-14
     */
    @Override
    public Dict findByDictType(String dictType) {
        return dictDao.findByDictType(dictType);
    }
}
