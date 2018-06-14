package cn.zhimadi.bss.security.dto;

import cn.zhimadi.bss.common.dto.BaseDTO;
import lombok.Data;

@Data
public class ResourceDTO extends BaseDTO {

    /** 父id */
    private String pId;

    /** 名称 */
    private String name;

    /** 路径 */
    private String uri;

    /** 标题 */
    private String title;
}
