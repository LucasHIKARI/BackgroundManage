package com.music.permission.vo;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.List;

/**
 * 登录对象
 */
public class LoginVo {

    private Integer userId;
    /**
     *
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 权限路径
     */
    private String path;

    /**
     * 状态（1：正常 0：停用）
     */
    private Integer status;


    /**
     * 地区/国家
     */
    private String region;

    /**
     * 默认管理权限是否开启
     */
    private String ifRight;

    /**
     * 权限路径的list
     */
    private List rights;




    public List getRights() {
        return rights;
    }

    public void setRights(List rights) {
        this.rights = rights;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getIfRight() {
        return ifRight;
    }

    public void setIfRight(String ifRight) {
        this.ifRight = ifRight;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
