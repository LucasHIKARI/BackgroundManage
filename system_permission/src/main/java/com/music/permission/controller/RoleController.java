package com.music.permission.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.model.SysRole;
import com.music.permission.result.Result;
import com.music.permission.service.SysRoleService;
import com.music.vo.AssginRoleVo;
import com.music.vo.RoleVo;
import com.music.vo.SysRoleQueryVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Lucas
 * @Date: 2022/12/31/031 12:52
 * @Description:
 */

@RestController
@RequestMapping("/right-manage/role")
public class RoleController {

    @Autowired
    private SysRoleService sysRoleService;

    //1 查询所有角色和权限
    @ApiOperation("查询所有角色和权限")
    @GetMapping("/list")
    public Result findAllRole() {

        //调用service
        List<RoleVo> list = sysRoleService.listAllRole();
        return Result.ok(list);
    }

    //2 查询所有记录
    @ApiOperation("查询所有角色")
    @GetMapping("/listAll")
    public Result findAll() {
        //调用service
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }


//    @ApiOperation("获取用户的角色数据")
//    @GetMapping("toAssign/{userId}")
//    public Result toAssign(@PathVariable String userId) {
//        Map<String,Object> roleMap = sysRoleService.getRolesByUserId(userId);
//        return Result.ok(roleMap);
//    }
//
//    @ApiOperation("用户分配角色")
//    @PostMapping("doAssign")
//    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo) {
//        sysRoleService.doAssign(assginRoleVo);
//        return Result.ok();
//    }



    //6 修改-最终修改
/*
    @PreAuthorize("hasAuthority('bnt.sysRole.update')")
*/
    @ApiOperation("最终修改")
    @PostMapping("update")
    public Result updateRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if(isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //5 修改-根据id查询
  /*  @PreAuthorize("hasAuthority('bnt.sysRole.list')")*/
    @ApiOperation("根据id查询")
    @PostMapping("findRoleById/{id}")
    public Result findRoleById(@PathVariable Long id) {
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    //4 添加
    // @RequestBody 不能使用get提交方式
    // 传递json格式数据，把json格式数据封装到对象里面 {...}
    /*@Log(title = "角色管理",businessType = BusinessType.INSERT)*/
    /*@PreAuthorize("hasAuthority('bnt.sysRole.add')")*/
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result saveRole(@RequestBody SysRole sysRole) {
        boolean isSuccess = sysRoleService.save(sysRole);
        if(isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //3 条件分页查询
    // page当前页  limit每页记录数
    /*@PreAuthorize("hasAuthority('bnt.sysRole.list')")*/
//    @ApiOperation("条件分页查询")
//    @GetMapping("{page}/{limit}")
//    public Result findPageQueryRole(@PathVariable Long page,
//                                    @PathVariable Long limit,
//                                    SysRoleQueryVo sysRoleQueryVo) {
//        //创建page对象
//        Page<SysRole> pageParam = new Page<>(page,limit);
//        //调用service方法
//        IPage<SysRole> pageModel = sysRoleService.selectPage(pageParam,sysRoleQueryVo);
//        //返回
//        return Result.ok(pageModel);
//    }

    //2 逻辑删除接口
//    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result removeRole(@PathVariable Long id) {
        //调用方法删除
        boolean isSuccess = sysRoleService.removeById(id);
        if(isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }



//    @ApiOperation("获取用户的角色数据")
//    @GetMapping("toAssign/{userId}")
//    public Result toAssign(@PathVariable String userId) {
//        Map<String,Object> roleMap = sysRoleService.getRolesByUserId(userId);
//        return Result.ok(roleMap);
//    }

//    @ApiOperation("用户分配角色")
//    @PostMapping("doAssign")
//    public Result doAssign(@RequestBody AssginRoleVo assginRoleVo) {
//        sysRoleService.doAssign(assginRoleVo);
//        return Result.ok();
//    }

    //7 批量删除
    // 多个id值 [1,2,3]
    // json数组格式 --- java的list集合
//    @PreAuthorize("hasAuthority('bnt.sysRole.remove')")
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids) {
        sysRoleService.removeByIds(ids);
        return Result.ok();
    }



}