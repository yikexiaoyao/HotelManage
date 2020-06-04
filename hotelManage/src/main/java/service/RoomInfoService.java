package service;

import java.util.List;
import java.util.Map;

public interface RoomInfoService {

    List<Map<String, String>> queryRoomInfo(Map<String, Object> info, int index, int pageSize);
    /**
    *@Description 查询房间信息 若是根据钱的范围来查使用discounted_price字段存放一个包含连个值的float对象数列 new float[]{1,2}
    *@Param [info, index, pageSize]
    *@Return java.util.List<java.util.Map<java.lang.String,java.lang.String>>
    *@Author Rong
    *@Date 2020/5/15
    *@Time 8:45
    */
    
    int updateRoomInfo( Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2);
    /**
    *@Description 跟新房间信息
    *@Param [user, info, info2]
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 8:45
    */

    int insertRoomInfo( Map<String, Object> user,Map<String, Object> info);
    /**
    *@Description 添加房间信息
    *@Param [user, info]
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 8:46
    */

    int deleteRoomInfo( Map<String, Object> user,String info);
    /**
    *@Description 删除数据
    *@Param [user, info]
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 9:08
    */

    int getRoomInfoCount(Map<String, Object> info);
    /**
    *@Description 获取数据个数
    *@Param [info]
    *@Return int
    *@Author Rong
    *@Date 2020/5/15
    *@Time 9:11
    */
}
