package com.music.permission.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.music.model.SysDept;
import com.music.permission.mapper.SysDeptMapper;
import com.music.permission.service.SysDeptService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【sys_dept(组织机构)】的数据库操作Service实现
* @createDate 2022-12-30 17:21:08
*/
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept>
implements SysDeptService{

}
