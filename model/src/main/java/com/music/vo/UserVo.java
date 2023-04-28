package com.music.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.music.model.SysUser;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Lucas
 * @Date: 2023/1/2/002 17:27
 * @Description:
 * 用户表
 * @TableName sys_user
 */
@TableName(value ="sys_user")
public class UserVo {


        /**
         * Userid
         */
        @TableId(value = "id",type = IdType.AUTO)
        private Long id;

        /**
         * 用户名
         */
        private String username;

        /**
         * 密码
         */
        private String password;

        /**
         * 姓名
         */
        private String name;

        /**
         * 手机
         */
        private String phone;

        /**
         * 头像地址
         */
        private String headUrl;

        /**
         * 部门id
         */
        private Long deptId;

        /**
         * 岗位id
         */
        private Long postId;

        /**
         * 描述
         */
        private String description;

        /**
         * 状态（1：正常 0：停用）
         */
        private Integer status;

        /**
         * 创建时间
         */
        private Date createTime;

        /**
         * 更新时间
         */
        private Date updateTime;

        /**
         * 地区/国家
         */
        private String region;

        /**
         * 默认管理权限是否开启
         */
        private String ifRight;

        /**
         * 删除标记（0:可用 1:已删除）
         */
    @TableLogic //逻辑删除 默认效果0没有删除1已经删除
        private Integer isDeleted;


    /**
     * ロール名称
     */
    @TableField(exist = false)
    private String role;

    /**
     * ロールID
     */
    @TableField(exist = false)
    private String roleId;

    /**
     * 权限路径
     */
    @TableField(exist = false)
    private String path;

    /**
     * 权限路径的list
     */
    @TableField(exist = false)
    private List rights;

    public List getRights() {
        return rights;
    }

    public void setRights(List rights) {
        this.rights = rights;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIfRight() {
        return ifRight;
    }

    public void setIfRight(String ifRight) {
        this.ifRight = ifRight;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @TableField(exist = false)
        private static final long serialVersionUID = 1L;

        /**
         * 会员id
         * @return
         */
        public Long getId() {
            return id;
        }

        /**
         * 会员id
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * 用户名
         */
        public String getUsername() {
            return username;
        }

        /**
         * 用户名
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         * 密码
         */
        public String getPassword() {
            return password;
        }

        /**
         * 密码
         */
        public void setPassword(String password) {
            this.password = password;
        }

        /**
         * 姓名
         */
        public String getName() {
            return name;
        }

        /**
         * 姓名
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * 手机
         */
        public String getPhone() {
            return phone;
        }

        /**
         * 手机
         */
        public void setPhone(String phone) {
            this.phone = phone;
        }

        /**
         * 头像地址
         */
        public String getHeadUrl() {
            return headUrl;
        }

        /**
         * 头像地址
         */
        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        /**
         * 部门id
         */
        public Long getDeptId() {
            return deptId;
        }

        /**
         * 部门id
         */
        public void setDeptId(Long deptId) {
            this.deptId = deptId;
        }

        /**
         * 岗位id
         */
        public Long getPostId() {
            return postId;
        }

        /**
         * 岗位id
         */
        public void setPostId(Long postId) {
            this.postId = postId;
        }

        /**
         * 描述
         */
        public String getDescription() {
            return description;
        }

        /**
         * 描述
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * 状态（1：正常 0：停用）
         */
        public Integer getStatus() {
            return status;
        }

        /**
         * 状态（1：正常 0：停用）
         */
        public void setStatus(Integer status) {
            this.status = status;
        }

        /**
         * 创建时间
         */
        public Date getCreateTime() {
            return createTime;
        }

        /**
         * 创建时间
         */
        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        /**
         * 更新时间
         */
        public Date getUpdateTime() {
            return updateTime;
        }

        /**
         * 更新时间
         */
        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        /**
         * 地区/国家
         */
        public String getRegion() {
            return region;
        }

        /**
         * 地区/国家
         */
        public void setRegion(String region) {
            this.region = region;
        }

        /**
         * 默认管理权限是否开启
         */
        public String getDefault() {
            return ifRight;
        }

        /**
         * 默认管理权限是否开启
         */
        public void setDefault(String ifRight) {
            this.ifRight = ifRight;
        }

        /**
         * 删除标记（0:可用 1:已删除）
         */
        public Integer getIsDeleted() {
            return isDeleted;
        }

        /**
         * 删除标记（0:可用 1:已删除）
         */
        public void setIsDeleted(Integer isDeleted) {
            this.isDeleted = isDeleted;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) {
                return true;
            }
            if (that == null) {
                return false;
            }
            if (getClass() != that.getClass()) {
                return false;
            }
            com.music.model.SysUser other = (com.music.model.SysUser) that;
            return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                    && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                    && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                    && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                    && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
                    && (this.getHeadUrl() == null ? other.getHeadUrl() == null : this.getHeadUrl().equals(other.getHeadUrl()))
                    && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
                    && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
                    && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                    && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                    && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                    && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                    && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
                    && (this.getDefault() == null ? other.getDefault() == null : this.getDefault().equals(other.getDefault()))
                    && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
            result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
            result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
            result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
            result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
            result = prime * result + ((getHeadUrl() == null) ? 0 : getHeadUrl().hashCode());
            result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
            result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
            result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
            result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
            result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
            result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
            result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
            result = prime * result + ((getDefault() == null) ? 0 : getDefault().hashCode());
            result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
            return result;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" [");
            sb.append("Hash = ").append(hashCode());
            sb.append(", id=").append(id);
            sb.append(", username=").append(username);
            sb.append(", password=").append(password);
            sb.append(", name=").append(name);
            sb.append(", phone=").append(phone);
            sb.append(", headUrl=").append(headUrl);
            sb.append(", deptId=").append(deptId);
            sb.append(", postId=").append(postId);
            sb.append(", description=").append(description);
            sb.append(", status=").append(status);
            sb.append(", createTime=").append(createTime);
            sb.append(", updateTime=").append(updateTime);
            sb.append(", region=").append(region);
            sb.append(", ifRight=").append(ifRight);
            sb.append(", isDeleted=").append(isDeleted);
            sb.append(", serialVersionUID=").append(serialVersionUID);
            sb.append("]");
            return sb.toString();
        }

}