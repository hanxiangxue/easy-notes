package com.easynotes.core.model;
/**
 * 角色javabean
 * @author Administrator
 *
 */
public class Role {
    private Integer id;//角色的id

    private String name;//角色的名字

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}