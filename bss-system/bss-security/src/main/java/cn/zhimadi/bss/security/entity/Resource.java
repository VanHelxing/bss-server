package cn.zhimadi.bss.security.entity;

import cn.zhimadi.bss.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bss_resource")
public class Resource extends BaseEntity {

    /** 父id */
    private String pId;

    /** 名称 */
    private String name;

    /** 路径 */
    private String uri;

    /** 标题 */
    private String title;

}
