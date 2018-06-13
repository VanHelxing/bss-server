package cn.zhimadi.bss.dict.dao;

import cn.zhimadi.bss.common.dao.BaseDao;
import cn.zhimadi.bss.dict.entity.Dict;
import org.springframework.stereotype.Repository;


/**
 * 字典信息持久类
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Repository
public interface DictDao extends BaseDao<Dict> {
}
