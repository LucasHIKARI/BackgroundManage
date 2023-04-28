package com.music.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.model.base.BaseEntity;

import lombok.Data;

@Data
/*@ApiModel(description = "用户角色关系表")*/
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	/*@ApiModelProperty(value = "角色id")*/
	@TableField("role_id")
	private String roleId;

	/*@ApiModelProperty(value = "用户id")*/
	@TableField("user_id")
	private String userId;
}

