package service;

import java.util.List;
import java.util.Map;

public interface OrderInfoService {

    List<Map<String, String>> queryRoomInfo(Map<String, Object> info, int index, int pageSize);
    /**
     *@Description  获取房间信息 若是根据钱的范围来查使用discounted_price字段存放一个包含连个值的float对象数列 new float[]{1,2}
     *@Param [info, index, pageSize] 要求，页号，数据数
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.String>>
     *@Author Rong
     *@Date 2020/5/15
     *@Time 8:30
     */

    List<Map<String, String>> queryBookCustomersInfo(Map<String, Object> info, int index, int pageSize);
    List<Map<String, String>> queryOrderInfo(Map<String, Object> info, int index, int pageSize);
    /**
     *@Description 获取预定信息
     *@Param [info, index, pageSize] 要求，页号，数据数
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.String>>
     *@Author Rong
     *@Date 2020/5/15
     *@Time 8:31
     */

    int updateOrderInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2, Map<String, Object> other);
    /**
     *@Description 更新预定数据 。可实现转入住的功能
     *@Param [user, info, info2, other] 执行用户信息（从session）中获取，修改内容，要修改的条件， 若是转入住操作存放 唤醒和早餐的需求
     *@Return int
     *@Author Rong
     *@Date 2020/5/15
     *@Time 8:32
     */

    int insertOrderInfo(Map<String, Object> user, Map<String, Object> info);
    /**
     *@Description 添加预定数据
     *@Param [user, info] 执行用户信息（从session）中获取， 添加的内容
     *@Return int
     *@Author Rong
     *@Date 2020/5/15
     *@Time 8:39
     */


    int getOrderInfoCount(Map<String, Object> info);
    /**
     *@Description  获取符合要求的数据个数
     *@Param [info] 要求信息
     *@Return int
     *@Author Rong
     *@Date 2020/5/15
     *@Time 8:40
     */

    int getRoomInfoCount(Map<String, Object> info);

    int getCheckinInfoCount(Map<String, Object> info);

    Map<String, String> toCheckIn(Map<String, Object> user, Map<String, Object> info,Map<String, Object> other);


    List<Map<String, String>> queryCheckinInfo(Map<String, Object> info, int index, int pageSize);

}
