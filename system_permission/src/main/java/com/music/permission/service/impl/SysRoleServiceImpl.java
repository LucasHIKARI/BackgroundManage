package com.music.permission.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.model.SysRole;
import com.music.permission.mapper.SysRoleMapper;
import com.music.permission.service.SysRoleService;
import com.music.vo.AssginRoleVo;
import com.music.vo.RoleVo;
import com.music.vo.SysRoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【sys_role(角色)】的数据库操作Service实现
* @createDate 2022-12-30 17:21:08
*/
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole>
implements SysRoleService{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<RoleVo> listAllRole() {
        List<RoleVo> roleVoList=sysRoleMapper.listAll();
        return roleVoList;
    }


    //条件分页查询
//    @Override
//    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo) {
//        IPage<SysRole> pageModel = baseMapper.selectPage(pageParam,sysRoleQueryVo);
//        return pageModel;
//
//    }

    //获取用户的角色数据
//    @Override
//    public Map<String, Object> getRolesByUserId(String userId) {
//        //获取所有角色
//        List<SysRole> roles = baseMapper.selectList(null);
//        //根据用户id查询，已经分配角色
//        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
//        wrapper.eq("user_id",userId);
//        List<SysRole> userRolesList = SysRoleMapper.selectList(wrapper);
//        //从userRoles集合获取所有角色id
//        List<String> userRoleIds = new ArrayList<>();
//        for (SysRole userRole:userRolesList) {
//            String roleId = String.valueOf(userRole.getId());
//            userRoleIds.add(roleId);
//        }
//        //封装到map集合
//        Map<String, Object> returnMap = new HashMap<>();
//        returnMap.put("allRoles",roles);//所有角色
//        returnMap.put("userRoleIds",userRoleIds);//用户分配角色id集合
//        return returnMap;
//    }

    //用户分配角色
//    @Override
//    public void doAssign(AssginRoleVo assginRoleVo) {
//        //根据用户id删除之前分配角色
//        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
//        wrapper.eq("user_id",assginRoleVo.getUserId());
//        SysRoleMapper.delete(wrapper);
//        //获取所有角色id，添加角色用户关系表
//        //角色id列表
//        List<String> roleIdList = assginRoleVo.getRoleIdList();
//        for (String roleId:roleIdList) {
//            SysRole userRole = new SysRole();
//            userRole.setUserId(assginRoleVo.getUserId());
//            userRole.setId(roleId);
//            SysRoleMapper.insert(userRole);
//        }
//    }
}
