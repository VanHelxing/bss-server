package cn.zhimadi.bss.dict.dto;

import cn.zhimadi.bss.common.dto.BaseDTO;
import lombok.Data;

/**
 * 字典DTO
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
public class DictDTO extends BaseDTO {

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 备注
     */
    private String remark;




}
