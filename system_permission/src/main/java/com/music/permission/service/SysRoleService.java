package com.music.permission.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.model.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.music.vo.AssginRoleVo;
import com.music.vo.RoleVo;
import com.music.vo.SysRoleQueryVo;

import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【sys_role(角色)】的数据库操作Service
* @createDate 2022-12-30 17:21:08
*/
public interface SysRoleService extends IService<SysRole> {

    List<RoleVo> listAllRole();
    //条件分页查询
//    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo);

    //获取用户的角色数据
//    Map<String, Object> getRolesByUserId(String userId);

    //用户分配角色
//    void doAssign(AssginRoleVo assginRoleVo);
}
