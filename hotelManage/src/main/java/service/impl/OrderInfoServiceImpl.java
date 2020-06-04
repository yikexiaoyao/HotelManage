package service.impl;

import dao.*;
import dao.impl.*;
import lombok.extern.slf4j.Slf4j;
import service.OrderInfoService;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class OrderInfoServiceImpl implements OrderInfoService {

    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private OrderInfoDao orderInfoDao = new OrderInfoDaoImpl();
    private RoomInfoDao roomInfoDao = new RoomInfoDaoImpl();
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();
    private CheckinInfoDao checkinInfoDao = new CheckinInfoDaoImpl();
    private MemberInfoDao memberInfoDao = new MemberInfoDaoImpl();

    @Override
    public List<Map<String, String>> queryRoomInfo(Map<String, Object> info, int index, int pageSize) {
        return roomInfoDao.queryRoomInfo(info, index, pageSize);
    }

    @Override
    public List<Map<String, String>> queryOrderInfo(Map<String, Object> info, int index, int pageSize) {
        return orderInfoDao.queryOrderInfo(info, index, pageSize);
    }
    @Override
    public List<Map<String, String>> queryBookCustomersInfo(Map<String, Object> info, int index, int pageSize) {
        return orderInfoDao.queryBookCustomersInfo(info, index, pageSize);
    }
    @Override
    public int updateOrderInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2, Map<String, Object> other) {
        Map<String, String> tempInfo = orderInfoDao.queryOrderInfo(info2).get(0);
        if (tempInfo.get("order_status").equals("正常")) {
            if (user.containsKey("authority")) {
                List<Map<String, String>> result = userInfoDao.queryUserInfo(user);
                if (result == null || result.isEmpty()) {
                    log.error("更新order_info失败 : 未知操作人操作");
                    return 0;
                }
                int temp = orderInfoDao.updateOrderInfo(info, info2);
                Map<String, Object> logInfo = new LinkedHashMap<>();
                logInfo.put("user_id", user.get("user_id"));
                logInfo.put("operate", String.format("对order_info表更新数据 %s ", info.toString()));
                logInfo.put("time", new Date());
                if (temp > 0) {
                    if (info.containsKey("order_status")) {

                        Map<String, Object> roomInfo = new HashMap<>();
                        roomInfo.put("room_id", tempInfo.get("room_id"));
                        Map<String, Object> roomInfo2 = new HashMap<>();

                        if (info.get("order_status").equals("已取消")) {
                            roomInfo2.put("status", "空房");
                        } else if (info.get("order_status").equals("已入住")) {

                            Map<String, Object> orderInfo = new LinkedHashMap<>();
                            orderInfo.putAll(tempInfo);
                            orderInfo.putAll(other);

                            if (CheckIn(user, orderInfo) != null) {
                                roomInfo2.put("status", "入住");
                            }
                        }
                        System.out.println(roomInfoDao.updateRoomInfo(roomInfo2, roomInfo));
                    }
                    logInfo.put("details", "操作成功");
                    logInfoDao.insertLogInfo(logInfo);
                    return 1;
                }
                logInfo.put("details", "操作失败");
                logInfoDao.insertLogInfo(logInfo);
            } else {
                int temp = orderInfoDao.updateOrderInfo(info, info2);
                if (temp > 0) {
                    if (info.containsKey("status")) {
                        Map<String, Object> roomInfo = new HashMap<>();
                        if (info.containsKey("room_id")) {
                            roomInfo.put("room_id", info.get("room_id"));
                        }
                        Map<String, Object> roomInfo2 = new HashMap<>();
                        if (info.get("status").equals("已取消")) {
                            roomInfo2.put("status", "空房");
                        }
                        roomInfoDao.updateRoomInfo(roomInfo2, roomInfo);
                    }
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override
    public int insertOrderInfo(Map<String, Object> user, Map<String, Object> info) {
        Map<String, Object> roomInfo = new HashMap<>();
        roomInfo.put("room_id", info.get("room_id"));
        if (roomInfoDao.queryRoomInfo(roomInfo).get(0).get("status").equals("空房")) {
            if (user.containsKey("authority")) {
                List<Map<String, String>> result = userInfoDao.queryUserInfo(user);
                if (result == null || result.isEmpty()) {
                    log.error("更新order_info失败 : 未知操作人操作");
                    return 0;
                }
                info.put("operator",user.get("user_id"));
                int temp = orderInfoDao.insertOrderInfo(info);
                Map<String, Object> logInfo = new LinkedHashMap<>();
                logInfo.put("user_id", user.get("user_id"));
                logInfo.put("operate", String.format("对order_info表插入数据 %s ", info.toString()));
                logInfo.put("time", new Date());
                if (temp > 0) {
                    Map<String, Object> roomInfo2 = new HashMap<>();
                    roomInfo2.put("status", "预定");
                    roomInfoDao.updateRoomInfo(roomInfo2, roomInfo);
                    logInfo.put("details", "操作成功");
                    logInfoDao.insertLogInfo(logInfo);

                    if (info.containsKey("member_id")) {
                        roomInfo.clear();
                        roomInfo2.clear();
                        roomInfo.put("member_id", info.get("member_id"));
                        roomInfo.put("scheduled_time", new Date());
                        memberInfoDao.updateMemberInfo(roomInfo2, roomInfo);
                    }


                    return 1;
                }
                logInfo.put("details", "操作失败");
                logInfoDao.insertLogInfo(logInfo);
            } else if (user.containsKey("member_id")){
                Map<String, Object> roomInfo2 = new HashMap<>();
                info.put("member_id",user.get("member_id"));
                int temp = orderInfoDao.insertOrderInfo(info);
                if (temp > 0) {
                    roomInfo2.put("status", "预定");
                    roomInfoDao.updateRoomInfo(roomInfo2, roomInfo);
                    roomInfo.clear();
                    roomInfo2.clear();
                    roomInfo.put("member_id", user.get("member_id"));
                    roomInfo.put("scheduled_time", new Date());
                    memberInfoDao.updateMemberInfo(roomInfo2, roomInfo);
                    return 1;
                } else {
                    return 0;
                }
            }else {
                log.info("no authority");
                return 0;
            }

        } else {
            log.info("房间不是空房状态");
        }
        return 0;
    }

    @Override
    public int getOrderInfoCount(Map<String, Object> info) {
        return orderInfoDao.getOrderInfoCount(info);
    }


    @Override
    public int getRoomInfoCount(Map<String, Object> info) {
        return roomInfoDao.getRoomInfoCount(info);
    }

    @Override
    public int getCheckinInfoCount(Map<String, Object> info) {
        return checkinInfoDao.getCheckinInfoCount(info);
    }

    @Override
    public Map<String, String> toCheckIn(Map<String, Object> user, Map<String, Object> info, Map<String, Object> other) {
        Map<String, String> tempInfo = orderInfoDao.queryOrderInfo(info).get(0);
        if (!tempInfo.get("order_status").equals("已入住")) {

            Map<String, Object> orderinfo = new HashMap<>();
            Map<String, Object> orderinfo2 = new HashMap<>();
            orderinfo.put("order_id", tempInfo.get("order_id"));
            orderinfo2.put("order_status", "已入住");

            Map<String, Object> roomInfo = new HashMap<>();
            Map<String, Object> roomInfo2 = new HashMap<>();
            roomInfo.put("room_id", tempInfo.get("room_id"));

            info.putAll(tempInfo);
            info.putAll(other);

            Map<String, String> result = CheckIn(user, info);
            if (result != null) {
                roomInfo2.put("status", "入住");
                roomInfoDao.updateRoomInfo(roomInfo2, roomInfo);
                orderInfoDao.updateOrderInfo(orderinfo2, orderinfo);
            }

            return result;
        }
        return null;
    }

    @Override
    public List<Map<String, String>> queryCheckinInfo(Map<String, Object> info, int index, int pageSize) {
        return checkinInfoDao.queryCheckinInfoIng(info, index, pageSize);
    }

    private Map<String, String> CheckIn(Map<String, Object> user, Map<String, Object> info) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Map<String, Object> roomInfo = new HashMap<>();
        roomInfo.put("room_id", info.get("room_id"));
        info.put("new_room_id", info.get("room_id"));
        info.put("checkiner", info.get("orderer"));
        info.put("operator", user.get("user_id"));
        info.put("arrivals_time", sdf.format(new Date()));

        info.remove("order_id");
        info.remove("room_id");
        info.remove("orderer");
        info.remove("order_status");
        info.remove("details");

        Map<String, String> temp1 = roomInfoDao.queryRoomInfo(roomInfo).get(0);
        if (!info.containsKey("member_id")) {
            info.put("checkin_price", temp1.get("discounted_price"));
        } else {
            roomInfo.clear();
            roomInfo.put("member_id", info.get("member_id"));
            String level = memberInfoDao.queryMemberInfo(roomInfo).get(0).get("level");
            if (level.equals("vip")) {
                info.put("checkin_price", temp1.get("vip_price"));
            } else {
                info.put("checkin_price", temp1.get("member_price"));
            }
        }
        int temp = checkinInfoDao.insertCheckinInfo(info);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对checin_info表更新数据 %s ", info.toString()));
        logInfo.put("time", new Date());
        if (temp > 0) {
            if (info.containsKey("member_id")) {
                Map<String, Object> memberInfo = new HashMap<>();
                Map<String, Object> memberInfo2 = new HashMap<>();
                memberInfo.put("member_id", info.get("member_id"));
                memberInfo2.put("check_in_time", new Date());
                memberInfoDao.updateMemberInfo(memberInfo2, memberInfo);
            }
            logInfo.put("details", "操作成功");
            logInfoDao.insertLogInfo(logInfo);

            user.clear();
            user.put("arrivals_time", info.get("arrivals_time"));
            return checkinInfoDao.queryCheckinInfo(user).get(0);
        }
        logInfo.put("details", "操作失败");
        logInfoDao.insertLogInfo(logInfo);
        return null;
    }
}