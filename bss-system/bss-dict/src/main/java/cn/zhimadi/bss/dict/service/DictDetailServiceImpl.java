package cn.zhimadi.bss.dict.service;

import cn.zhimadi.bss.common.dao.BaseDao;
import cn.zhimadi.bss.common.service.BaseServiceImpl;
import cn.zhimadi.bss.dict.dao.DictDetailDao;
import cn.zhimadi.bss.dict.entity.DictDetail;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


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
}
