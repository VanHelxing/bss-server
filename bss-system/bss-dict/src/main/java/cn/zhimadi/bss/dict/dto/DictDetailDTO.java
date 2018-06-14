package cn.zhimadi.bss.dict.dto;

import cn.zhimadi.bss.common.dto.BaseDTO;
import lombok.Data;

/**
 * 字典明细DTO
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
public class DictDetailDTO extends BaseDTO {

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * No
     */
    private Integer no;

    /**
     * 节点code
     */
    private String treeCode;

    /**
     * 节点value
     */
    private String treeValue;

    /**
     * 备注
     */
    private String remark;
}
