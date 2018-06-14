package cn.zhimadi.bss.dict.dao;

import cn.zhimadi.bss.common.dao.BaseDao;
import cn.zhimadi.bss.dict.entity.DictDetail;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 字典明细持久类
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Repository
public interface DictDetailDao extends BaseDao<DictDetail> {

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
