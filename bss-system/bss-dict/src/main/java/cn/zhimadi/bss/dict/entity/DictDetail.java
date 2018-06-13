package cn.zhimadi.bss.dict.entity;

import cn.zhimadi.bss.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 字典明细
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "bss_dict_detail")
public class DictDetail extends BaseEntity {

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
