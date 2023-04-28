package com.music.permission.utils;

import com.music.vo.SysAuthorityVo;
import java.util.ArrayList;
import java.util.List;
//封装嵌套数组的返回数据集工具类
public class MenuHelper {

    //构建树形结构
//    传入获取所有菜单（……）的list
    public static List<SysAuthorityVo> bulidTree(List<SysAuthorityVo> sysAuthorityVoList) {
        //创建集合封装最终数据
        List<SysAuthorityVo> trees = new ArrayList<>();
        //遍历所有菜单集合
        for (SysAuthorityVo sysAuthorityVo:sysAuthorityVoList) {
            //找到递归入口，parentid=0
            if(sysAuthorityVo.getParentId().longValue()==0) {
                trees.add(findChildren(sysAuthorityVo,sysAuthorityVoList));
            }
        }
        return trees;
    }

    //从根节点进行递归查询，查询子节点
    // 判断 id =  parentid是否相同，如果相同是子节点，进行数据封装
    private static SysAuthorityVo findChildren(SysAuthorityVo sysAuthorityVo, List<SysAuthorityVo> treeNodes) {
        //数据初始化
        sysAuthorityVo.setChildren(new ArrayList<SysAuthorityVo>());
        //遍历递归查找
        for (SysAuthorityVo it:treeNodes) {
            //获取当前菜单id
//            String id = sysAuthorityVo.getId();
//            long cid = Long.parseLong(id);
            //获取所有菜单parentid
//            Long parentId = it.getParentId();
            //比对 查看sysAuthorityVo数据行有没有子数据行
            if(sysAuthorityVo.getId()==it.getParentId()) {
                if(sysAuthorityVo.getChildren()==null) {
                    sysAuthorityVo.setChildren(new ArrayList<>());
                }
//                在查看it数据行有没有子数据行，通过递归不断调用穷尽子数据行
                sysAuthorityVo.getChildren().add(findChildren(it,treeNodes));
            }
        }
        return sysAuthorityVo;
    }
}
