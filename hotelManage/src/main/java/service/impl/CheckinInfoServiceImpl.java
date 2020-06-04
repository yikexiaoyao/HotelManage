package service.impl;

import dao.*;
import dao.impl.*;
import lombok.extern.slf4j.Slf4j;
import service.CheckinInfoService;

import java.util.*;
@Slf4j
public class CheckinInfoServiceImpl implements CheckinInfoService {
    private RoomInfoDao roomInfoDao = new RoomInfoDaoImpl();
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private CheckinInfoDao checkinInfoDao = new CheckinInfoDaoImpl();
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();
    private MemberInfoDao memberInfoDao = new MemberInfoDaoImpl();

    @Override
    public List<Map<String, String>> queryRoomInfo(Map<String, Object> info, int index, int pageSize) {
        return roomInfoDao.queryRoomInfo(info,index,pageSize);
    }
    @Override
    public List<Map<String, String>> queryCheckinCustomersInfo(Map<String, Object> info, int index, int pageSize) {
        return checkinInfoDao.queryCheckinCustomersInfo(info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryTodayLeaveCustomersInfo(Map<String, Object> info, int index, int pageSize) {
        return checkinInfoDao.queryCheckinCustomersInfo1(info,index,pageSize);
    }
    @Override
    public int insertCheckinInfo(Map<String, Object> user, Map<String, Object> info) {
        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新check_info失败 : 未知操作人操作");
            return 0;
        }
        Map<String, Object> roomInfo = new HashMap<>();
        Map<String, Object> roomInfo2 = new HashMap<>();
        roomInfo2.put("room_id",info.get("new_room_id"));
        Map<String, String> temp = roomInfoDao.queryRoomInfo(roomInfo2).get(0);
        info.put("arrivals_time", new Date());

        if (!info.containsKey("member_id")){
            info.put("checkin_price",temp.get("discounted_price"));
        }else {
            roomInfo.put("member_id",info.get("member_id"));
            String level = memberInfoDao.queryMemberInfo(roomInfo).get(0).get("level");
            if (level.equals("vip")){
                info.put("checkin_price",temp.get("vip_price"));
            }else {
                info.put("checkin_price",temp.get("member_price"));
            }
        }
        info.put("order_to",0);
        info.put("operator",user.get("user_id"));
        int temp1 = checkinInfoDao.insertCheckinInfo(info);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对checkin_info表更新数据 %s ", info.toString()));
        logInfo.put("time", new Date());
        if (temp1 > 0) {
            roomInfo.clear();
            roomInfo.put("status", "入住");
            roomInfoDao.updateRoomInfo(roomInfo, roomInfo2);

            if (info.containsKey("member_id")){
                System.out.println(111111);
                roomInfo.clear();
                roomInfo2.clear();
                roomInfo.put("member_id",info.get("member_id"));
                roomInfo2.put("check_in_time",new Date());
                memberInfoDao.updateMemberInfo(roomInfo2,roomInfo);
            }

            logInfo.put("details", "操作成功");
            logInfoDao.insertLogInfo(logInfo);
            return 1;
        }
        logInfo.put("details", "操作失败");
        logInfoDao.insertLogInfo(logInfo);
        return 0;

    }

    @Override
    public List<Map<String, String>> queryCheckinInfo(Map<String, Object> info, int index, int pageSize) {
        return checkinInfoDao.queryCheckinInfoIng(info,index,pageSize);
    }

    @Override
    public int getRoomInfoCount(Map<String, Object> info) {
        return roomInfoDao.getRoomInfoCount(info);
    }

    @Override
    public int getCheckinInfoCount(Map<String, Object> info) {
        info.put("order_to",0);
        return checkinInfoDao.getCheckinInfoCount(info);
    }
}
