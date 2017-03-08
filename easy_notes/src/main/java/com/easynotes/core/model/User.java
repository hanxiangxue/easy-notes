package com.easynotes.core.model;

import java.util.Date;
/**
 * 用户javabean
 * @author Administrator
 *
 */
public class User {
    private Integer id;//用户id

    private String name;//用户名

    private String password;//用户密码

    private Integer state;//用户状态。0为已删除，1为未删除

    private Integer roleId;//用户角色

    private Date createTime;//创建时间

    private Date lastLoginTime;//最近登录时间

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}