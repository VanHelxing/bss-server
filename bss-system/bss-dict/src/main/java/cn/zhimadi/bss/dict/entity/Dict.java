package cn.zhimadi.bss.dict.entity;

import cn.zhimadi.bss.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 字典主表
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "bss_dict")
public class Dict extends BaseEntity {

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

    /**
     * 字典明细
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dictType")
    private Set<DictDetail> dictDetails = new HashSet<>();
}
