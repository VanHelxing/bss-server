package cn.zhimadi.bss.dict.service;

import cn.zhimadi.bss.common.service.BaseService;
import cn.zhimadi.bss.dict.entity.DictDetail;

import java.util.List;

/**
 * 字典明细接口
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public interface DictDetailService extends BaseService<DictDetail> {

    /**
     * Find by dict type and no dict detail.
     *
     * @param dictType the dict typr
     * @param no       the no
     * @return the dict detail
     * @author : yangjunqing / 2018-06-14
     */
    public DictDetail findByDictTypeAndNo(String dictType, Integer no);


    /**
     * Find by dict type dict detail.
     *
     * @param dictType the dict type
     * @return the dict detail
     * @author : yangjunqing / 2018-06-14
     */
    public List<DictDetail> findByDictType(String dictType);
}
