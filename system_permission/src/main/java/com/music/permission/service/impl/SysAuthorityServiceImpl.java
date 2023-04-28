package com.music.permission.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.model.SysAuthority;
import com.music.model.SysRoleMenu;
import com.music.permission.mapper.SysAuthorityMapper;
import com.music.permission.mapper.SysRoleMapper;
import com.music.permission.mapper.SysRoleMenuMapper;
import com.music.permission.service.SysAuthorityService;
import com.music.permission.utils.MenuHelper;
import com.music.vo.AssginMenuVo;
import com.music.vo.SysAuthorityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Administrator
* @description 针对表【sys_authority(菜单表)】的数据库操作Service实现
* @createDate 2022-12-30 17:19:42
*/
@Service
public class SysAuthorityServiceImpl extends ServiceImpl<SysAuthorityMapper, SysAuthorityVo>
implements SysAuthorityService{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    //菜单列表（树形）
    @Override
    public List<SysAuthorityVo> findNodes() {
        //获取所有菜单
        List<SysAuthorityVo> sysMenuList = baseMapper.selectList(null);
        //所有菜单数据转换要求数据格式
        List<SysAuthorityVo> resultList = MenuHelper.bulidTree(sysMenuList);
        return resultList;
    }




    //根据角色分配菜单
    @Override
    public List<SysAuthorityVo> findMenuByRoleId(String roleId) {
        //获取所有菜单 status=1
        QueryWrapper<SysAuthorityVo> wrapperMenu = new QueryWrapper<>();
        wrapperMenu.eq("status",1);
        List<SysAuthorityVo> menuList = baseMapper.selectList(wrapperMenu);

        //根据角色id查询 角色分配过的菜单列表
        QueryWrapper<SysRoleMenu> wrapperRoleMenu = new QueryWrapper<>();
        wrapperRoleMenu.eq("role_id",roleId);
        List<SysRoleMenu> roleMenus = sysRoleMenuMapper.selectList(wrapperRoleMenu);


        //从第二步查询列表中，获取角色分配所有权限菜单id
        List<String> roleMenuIds = new ArrayList<>();
        for (SysRoleMenu sysRoleMenu:roleMenus) {
            String menuId = sysRoleMenu.getMenuId();
            roleMenuIds.add(menuId);
        }

        //数据处理：isSelect 如果菜单选中 true，否则false
        // 拿着分配菜单id 和 所有菜单比对，有相同的，让isSelect值true
        for (SysAuthorityVo sysMenu:menuList) {
            String sysMenuId = sysMenu.getId().toString();
            if(roleMenuIds.contains(sysMenuId)) {
                sysMenu.setSelect(true);
            } else {
                sysMenu.setSelect(false);
            }
        }

        //转换成树形结构为了最终显示 MenuHelper方法实现
        List<SysAuthorityVo> sysMenus = MenuHelper.bulidTree(menuList);
        return sysMenus;
    }

    //给角色分配菜单权限
    @Override
    public void doAssign(AssginMenuVo assginMenuVo) {
        //根据角色id删除菜单权限
        QueryWrapper<SysRoleMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",assginMenuVo.getRoleId());
        sysRoleMenuMapper.delete(wrapper);

        //遍历菜单id列表，一个一个进行添加
        List<String> menuIdList = assginMenuVo.getMenuIdList();
        for (String menuId:menuIdList) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenu.setRoleId(assginMenuVo.getRoleId());
            sysRoleMenuMapper.insert(sysRoleMenu);
        }
    }
}
