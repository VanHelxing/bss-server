package cn.zhimadi.bss.dict.service;

import cn.zhimadi.bss.common.dao.BaseDao;
import cn.zhimadi.bss.common.service.BaseServiceImpl;
import cn.zhimadi.bss.dict.dao.DictDetailDao;
import cn.zhimadi.bss.dict.entity.DictDetail;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 字典明细接口实现类
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Service
public class DictDetailServiceImpl extends BaseServiceImpl<DictDetail> implements DictDetailService {

    @Autowired
    private DictDetailDao dictDetailDao;


    @Override
    protected BaseDao<DictDetail> getDao() {
        return dictDetailDao;
    }


    /**
     * Find by dict type and no dict detail.
     *
     * @param dictType the dict typr
     * @param no       the no
     * @return the dict detail
     * @author : yangjunqing / 2018-06-14
     */
    @Override
    public DictDetail findByDictTypeAndNo(String dictType, Integer no) {
        return dictDetailDao.findByDictTypeAndNo(dictType, no);
    }


    /**
     * Find by dict type dict detail.
     *
     * @param dictType the dict type
     * @return the dict detail
     * @author : yangjunqing / 2018-06-14
     */
    @Override
    public List<DictDetail> findByDictType(String dictType) {
        return dictDetailDao.findByDictType(dictType);
    }
}
