package com.music.permission.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.music.permission.result.Result;
import com.music.permission.service.SysUserService;
import com.music.permission.utils.MD5;
import com.music.vo.SysUserQueryVo;
import com.music.vo.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.music.permission.utils.MD5.MD5WithSalt;

/**
 * @Auther: Lucas
 * @Date: 2022/12/31/031 12:52
 * @Description:
 */

@RestController
/*@RequestMapping("/users")*/
@RequestMapping("/user-manage")
public class UserController {

    @Autowired
    private SysUserService sysUserService;


/*@GetMapping("/{page}/{limit}")
    public Result listt(@PathVariable Long page,@PathVariable Long limit,SysUserVo sysUserVo){
    Page<UserVo> pageParam = new Page<>(page, limit);
    IPage<UserVo> pagelist=sysUserService.selectPage(pageParam,sysUserVo);
    return Result.ok(pagelist);

}*/





    @GetMapping("/list")
    public Result list( ){
//       int i =1/0;
        List<UserVo> sysUserList = sysUserService.listUser();
        return  Result.ok(sysUserList);
    }



    @ApiOperation("更改用户状态")
    @GetMapping("/update/{id}/{status}")
    public Result updateStatus(@PathVariable String id,
                               @PathVariable Integer status) {
        sysUserService.updateStatus(id,status);
        return Result.ok();
    }



    @ApiOperation("添加用户")
    @PostMapping("/save")
    public Result save(@RequestBody UserVo user) {
        //把输入密码进行加鹽加密 MD5
        String encrypt = MD5WithSalt(user.getPassword(),0);
//        String encrypt = MD5.encrypt(user.getPassword());
        user.setPassword(encrypt);
        boolean is_Success = sysUserService.save(user);
        System.out.println(user.getRoleId());

        Integer  userId=sysUserService.searchSavedUserId(user);
        user.setId(Long.valueOf(userId));

        sysUserService.saveUserRole(user);

        if(is_Success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("根据id查询")
    @GetMapping("getUser/{id}")
    public Result getUser(@PathVariable String id) {
        UserVo user = sysUserService.getById(id);
        return Result.ok(user);
    }

    @ApiOperation("修改用户")
    @PostMapping("update")
    public Result update(@RequestBody UserVo user) {
        //每次更改用戶信息后都會生成新鹽值存入數據庫密碼
        String md5WithSalt = MD5WithSalt(user.getPassword(), 0);
        user.setPassword(md5WithSalt);
        boolean is_Success = sysUserService.updateById(user);
        if(is_Success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("删除用户")
    @GetMapping("remove/{id}")
    public Result remove(@PathVariable String id) {
        boolean is_Success = sysUserService.removeById(id);

        if(is_Success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

}