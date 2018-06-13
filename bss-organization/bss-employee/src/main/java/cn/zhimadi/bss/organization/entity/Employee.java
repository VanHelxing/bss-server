package cn.zhimadi.bss.organization.entity;


import cn.zhimadi.bss.common.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 员工信息
 *
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
@Entity
@Table(name = "bss_employee")
public class Employee extends BaseEntity {

    /**
     * 员工编号
     */
    private String empId;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 小组编号
     */
    private String groupId;

    /**
     * 员工类别
     */
    private String empType;
}
