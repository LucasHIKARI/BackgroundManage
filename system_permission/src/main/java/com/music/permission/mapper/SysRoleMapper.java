package com.music.permission.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.music.model.SysRole;
import com.music.model.SysRoleMenu;
import com.music.vo.RoleVo;
import com.music.vo.SysAuthorityVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_role(角色)】的数据库操作Mapper
* @createDate 2022-12-30 17:21:08
* @Entity com.music.model.SysRole
*/
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {


      List<RoleVo> listAll();

//      List<SysRoleMenu> selectListByRoleId(String roleId);
}
