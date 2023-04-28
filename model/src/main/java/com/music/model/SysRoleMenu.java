package com.music.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.music.model.base.BaseEntity;

import lombok.Data;

@Data
/*@ApiModel(description = "角色权限关系")*/
@TableName("sys_role_authority")
public class SysRoleMenu extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

/*	@ApiModelProperty(value = "角色id")*/
	@TableField("role_id")
	private String roleId;

/*	@ApiModelProperty(value = "权限id")*/
	@TableField("authority_id")
	private String menuId;

}

