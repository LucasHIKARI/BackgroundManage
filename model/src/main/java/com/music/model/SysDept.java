package com.music.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 组织机构
 * @TableName sys_dept
 */
@TableName(value ="sys_dept")
public class SysDept implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 上级部门id
     */
    private Long parentId;

    /**
     * 树结构
     */
    private String treePath;

    /**
     * 排序
     */
    private Integer sortValue;

    /**
     * 负责人
     */
    private String leader;

    /**
     * 电话
     */
    private String phone;

    /**
     * 状态（1正常 0停用）
     */
    private Integer status;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 删除标记（0:可用 1:已删除）
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 上级部门id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 上级部门id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 树结构
     */
    public String getTreePath() {
        return treePath;
    }

    /**
     * 树结构
     */
    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    /**
     * 排序
     */
    public Integer getSortValue() {
        return sortValue;
    }

    /**
     * 排序
     */
    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    /**
     * 负责人
     */
    public String getLeader() {
        return leader;
    }

    /**
     * 负责人
     */
    public void setLeader(String leader) {
        this.leader = leader;
    }

    /**
     * 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 状态（1正常 0停用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态（1正常 0停用）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        SysDept other = (SysDept) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getTreePath() == null ? other.getTreePath() == null : this.getTreePath().equals(other.getTreePath()))
            && (this.getSortValue() == null ? other.getSortValue() == null : this.getSortValue().equals(other.getSortValue()))
            && (this.getLeader() == null ? other.getLeader() == null : this.getLeader().equals(other.getLeader()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getTreePath() == null) ? 0 : getTreePath().hashCode());
        result = prime * result + ((getSortValue() == null) ? 0 : getSortValue().hashCode());
        result = prime * result + ((getLeader() == null) ? 0 : getLeader().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", parentId=").append(parentId);
        sb.append(", treePath=").append(treePath);
        sb.append(", sortValue=").append(sortValue);
        sb.append(", leader=").append(leader);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}