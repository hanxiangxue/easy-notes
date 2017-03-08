package com.easynotes.core.model;

import java.util.Date;
/**
 * 字典javabean
 * @author Administrator
 *
 */
public class Dictionary {
    private Integer id;//字典id

    private String name;//字典名

    private Integer type;//字典类型

    private Integer userId;//用户id
    
    private Integer state;//字典状态

    private Date createTime;//创建时间

    private Date lastUpdateTime;//最近更新时间

   

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}