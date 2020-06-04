package service.impl;

import dao.*;
import dao.impl.*;
import lombok.extern.slf4j.Slf4j;
import service.ReplaceRoomService;

import java.util.*;
@Slf4j
public class ReplaceRoomServiceImpl implements ReplaceRoomService {

    private RoomInfoDao roomInfoDao = new RoomInfoDaoImpl();
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private CheckinInfoDao checkinInfoDao = new CheckinInfoDaoImpl();
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();
    private CostInfoDao costInfoDao = new CostInfoDaoImpl();
    @Override
    public List<Map<String, String>> queryCheckinInfo(Map<String, Object> info, int index, int pageSize) {
        return checkinInfoDao.queryCheckinInfoIng(info,index,pageSize);
    }

    @Override
    public int updateCheckinInfo(Map<String, Object> user, Map<String, Object> info,Map<String, Object> info2) {
        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新checkin_info失败 : 未知操作人操作");
            return 0;
        }
        info.put("old_room_id",checkinInfoDao.queryCheckinInfo(info2).get(0).get("new_room_id"));
        info.put("operator",user.get("user_id"));
        int temp = checkinInfoDao.updateCheckinInfo(info,info2);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对checin_info表更新数据 %s ", info.toString()));
        logInfo.put("time", new Date());
        if (temp > 0) {
            Map<String, Object> roomInfo = new HashMap<>();
            roomInfo.put("status", "入住");
            Map<String, Object> roomInfo2 = new HashMap<>();
            roomInfo2.put("room_id",info.get("new_room_id"));
            roomInfoDao.updateRoomInfo(roomInfo, roomInfo2);
            roomInfo.put("status","空房");
            roomInfo2.put("room_id",info.get("old_room_id"));
            roomInfoDao.updateRoomInfo(roomInfo, roomInfo2);

            logInfo.put("details", "操作成功");
            logInfoDao.insertLogInfo(logInfo);
            return 1;
        }
        logInfo.put("details", "操作失败");
        logInfoDao.insertLogInfo(logInfo);
        return 0;

    }

    @Override
    public int getCheckinInfoCount(Map<String, Object> info) {
        return checkinInfoDao.getCheckinInfoCount(info);
    }
}
