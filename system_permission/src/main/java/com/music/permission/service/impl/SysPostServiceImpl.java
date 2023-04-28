package com.music.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.model.SysPost;
import com.music.permission.mapper.SysPostMapper;
import com.music.permission.service.SysPostService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【sys_post(岗位信息表)】的数据库操作Service实现
* @createDate 2022-12-30 17:21:08
*/
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost>
implements SysPostService{

}
