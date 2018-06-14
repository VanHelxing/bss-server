package cn.zhimadi.bss.dict.service;

import cn.zhimadi.bss.common.service.BaseService;
import cn.zhimadi.bss.dict.entity.Dict;

/**
 * 字典信息接口
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
public interface DictService extends BaseService<Dict> {

    /**
     * Find by dict dictType.
     *
     * @param dictType the dict type
     * @return the dict
     * @author : yangjunqing / 2018-06-14
     */
    public Dict findByDictType(String dictType);
}
