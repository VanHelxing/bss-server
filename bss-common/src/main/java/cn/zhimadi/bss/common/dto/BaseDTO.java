package cn.zhimadi.bss.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础DTO
 * @author : yangjunqing / yangjunqing@zhimadi.cn
 * @version : 1.0
 */
@Data
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 创建人 */
    private String createBy;

    /** 创建时间 */
    private Date createDate;

    /** 修改人 */
    private String updateBy;

    /** 修改时间 */
    private Date updateDate;

    /**
     * 状态
     */
    private String status;

    /**
     * 版本号(乐观锁)
     */
    private Long version;

    /**
     * 编辑状态(0 - 新增, 1 - 修改. 2 - 删除)
     */
    private String modifyRecord;


}
