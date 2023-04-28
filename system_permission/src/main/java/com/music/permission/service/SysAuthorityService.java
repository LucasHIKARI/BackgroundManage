package com.music.permission.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.music.model.SysAuthority;
import com.music.vo.AssginMenuVo;
import com.music.vo.SysAuthorityVo;

import java.util.List;


/**
* @author Administrator
* @description 针对表【sys_authority(菜单表)】的数据库操作Service
* @createDate 2022-12-30 17:19:42
*/
public interface SysAuthorityService extends IService<SysAuthorityVo> {

    //菜单列表（树形）
    List<SysAuthorityVo> findNodes();



    //根据角色分配菜单
    List<SysAuthorityVo> findMenuByRoleId(String roleId);

    //给角色分配菜单权限
    void doAssign(AssginMenuVo assginMenuVo);

//    //根据userid查询菜单权限值
//    List<RouterVo> getUserMenuList(String id);

    //根据userid查询按钮权限值
//    List<String> getUserButtonList(String id);
//    // //删除菜单
//    void removeMenuById(String id);
}
