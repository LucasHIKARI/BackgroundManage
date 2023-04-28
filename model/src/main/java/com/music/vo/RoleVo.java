package com.music.vo;



import com.music.model.SysRole;
import lombok.Data;

import java.util.List;

/*@ApiModel(description = "分配菜单")*/
@Data
public class RoleVo extends SysRole {


  /*  @ApiModelProperty(value = "用户id")*/
    private String userId;

/*    @ApiModelProperty(value = "角色id列表")*/
    private List<String> roleIdList;
//权限路径
    private String path;
//权限名
    private String rightName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<String> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }
}
