package com.music.permission.controller;

import com.music.model.SysAuthority;
import com.music.permission.result.Result;
import com.music.permission.service.SysAuthorityService;
import com.music.vo.AssginMenuVo;
import com.music.vo.SysAuthorityVo;
import com.music.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Lucas
 * @Date: 2023/1/1/001 22:37
 * @Description:
 */
@RestController
@RequestMapping("/right-manage/right")
public class RightController {

    @Autowired
    private SysAuthorityService sysAuthorityService;


//    @GetMapping("/list")
//    public Result list( ){
//
//        List<UserVo> sysUserList = sysAuthorityService.listRight();
//        return  Result.ok(sysUserList);
//    }


    @ApiOperation("给角色分配菜单权限")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginMenuVo assginMenuVo) {
        sysAuthorityService.doAssign(assginMenuVo);
        return Result.ok();
    }

    //根据角色分配菜单
    @ApiOperation("根据角色获取菜单")
    @GetMapping("/list/{roleId}")
    public Result toAssign(@PathVariable String roleId) {
        List<SysAuthorityVo> list = sysAuthorityService.findMenuByRoleId(roleId);
        return Result.ok(list);
    }

    //菜单列表（树形）
    @ApiOperation("菜单列表")
    @GetMapping("/list")
    public Result findNodes() {
        List<SysAuthorityVo> list = sysAuthorityService.findNodes();
        return Result.ok(list);
    }



/*

    //添加菜单
    @ApiOperation("添加菜单")
    @PostMapping("save")
    public Result save(@RequestBody SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return Result.ok();
    }

    //根据id查询
    @ApiOperation("根据id查询菜单")
    @GetMapping("findNode/{id}")
    public Result findNode(@PathVariable String id) {
        SysMenu sysMenu = sysMenuService.getById(id);
        return  Result.ok(sysMenu);
    }

    //修改
    @ApiOperation("修改菜单")
    @PostMapping("update")
    public Result update(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateById(sysMenu);
        return Result.ok();
    }

    //删除菜单
    @ApiOperation("删除菜单")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable String id) {
        sysMenuService.removeMenuById(id);
        return Result.ok();
    }*/


}