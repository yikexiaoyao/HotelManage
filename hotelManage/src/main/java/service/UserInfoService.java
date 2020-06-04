package service;

import java.util.List;
import java.util.Map;

public interface UserInfoService {

    boolean login(Map<String, Object> info);
    /**
    *@Description 登录验证
    *@Param [info] 登录信息
    *@Return boolean 若是验证通过返回true
    *@Author Rong
    *@Date 2020/5/15
    *@Time 8:17
    */

    List<Map<String, String>> queryUserInfoByLike(Map<String, Object> info);
    /**
    *@Description  模糊查询 【可选用】
    *@Param [info] 查询的要求
    *@Return java.util.List<java.util.Map<java.lang.String,java.lang.String>> 返回查询的结果
    *@Author Rong
    *@Date 2020/5/15
    *@Time 8:18
    */


    List<Map<String, String>> queryUserInfo(Map<String, Object> info, int index, int pageSize);
    /**
    *@Description  分页查询
    *@Param [info, index, pageSize] 查询信息，页号，数据条数
    *@Return java.util.List<java.util.Map<java.lang.String,java.lang.String>> 返回查询结果
    *@Author Rong
    *@Date 2020/5/15
    *@Time 8:19
    */

    int updateUserInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2);
    /**
    *@Description 更新数据
    *@Param [user, info, info2] 用户信息（从session） 中获取，修改的数据，要修改的信息
    *@Return int 执行结果 若成功 返回大于0的值
    *@Author Rong
    *@Date 2020/5/15
    *@Time 8:21
    */

    int insertUserInfo(Map<String, Object> user,  Map<String, Object> info);
    /**
    *@Description 插入数据
    *@Param [user, info] 执行用户信息（从session）中获取，要插入的数据
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 8:23
    */

    int deleteUserInfo(Map<String, Object> user, String info);
    /**
    *@Description  删除信息
    *@Param [user, info]  执行用户信息（从session）中获取，要删除的数据
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 8:26
    */

    int getUserInfoCount(Map<String, Object> info);
    /**
    *@Description 获取要求的数据数量
    *@Param [info] 要求， 若是空或为null则获取全部
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 8:27
    */
}
