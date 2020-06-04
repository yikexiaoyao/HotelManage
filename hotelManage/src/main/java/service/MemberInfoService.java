package service;

import java.util.List;
import java.util.Map;

public interface MemberInfoService {
    boolean login(Map<String, Object> info);
    /**
    *@Description 用户登录
    *@Param [info]
    *@Return boolean 验证成功返回true
    *@Author Rong
    *@Date 2020/5/15
    *@Time 9:12
    */

    List<Map<String, String>> queryMemberInfoByLike(Map<String, Object> info);
    /**
    *@Description 模糊查询 【选用】
    *@Param [info]
    *@Return java.util.List<java.util.Map<java.lang.String,java.lang.String>>
    *@Author Rong
    *@Date 2020/5/15
    *@Time 9:12
    */

    List<Map<String, String>> queryMemberInfo(Map<String, Object> info, int index, int pageSize);
    /**
    *@Description 查询信息
    *@Param [info, index, pageSize]
    *@Return java.util.List<java.util.Map<java.lang.String,java.lang.String>>
    *@Author Rong
    *@Date 2020/5/15
    *@Time 9:12
    */

    int updateMemberInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2);
    /**
    *@Description
    *@Param [user, info, info2]执行用户信息（从session）中获取，修改信息，要修改的数据要求
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 9:13
    */

    int insertMemberInfo(Map<String, Object> user, Map<String, Object> info);
    /**
    *@Description 添加信息，可以使用于注册
    *@Param [user,  info] 执行用户信息（从session）中获取（若是用户注册该信息为null） ，添加的信息
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 9:14
    */


    int deleteMemberInfo(Map<String, Object> user, String info);
    /**
    *@Description 删除数据
    *@Param [user, info] 执行用户信息（从session）中获取，要删除的信息
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 9:15
    */

    int getMemberInfoCount(Map<String, Object> info);
    /**
    *@Description 要获取数据个数
    *@Param [info]
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 9:16
    */
}
