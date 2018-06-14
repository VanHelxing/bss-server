package cn.zhimadi.bss.dict.entity;

import lombok.Data;

/**
 * 使用zTree插件的数据格式
 */
@Data
public class ResourceTree {

    private String id;

    private String pId;

    private String name;

    private String url;

    private Integer open;

    private Integer isHidden;

    private String title;

    private String target;

    public ResourceTree(String id, String pId, String name, String url, Integer open, Integer isHidden, String title, String target) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.url = url;
        this.open = open;
        this.isHidden = isHidden;
        this.title = title;
        this.target = target;
    }
}
