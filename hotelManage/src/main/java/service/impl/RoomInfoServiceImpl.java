package service.impl;

import dao.LogInfoDao;
import dao.RoomInfoDao;
import dao.RoomTypeDao;
import dao.UserInfoDao;
import dao.impl.LogInfoDaoImpl;
import dao.impl.RoomInfoDaoImpl;
import dao.impl.RoomTypeDaoImpl;
import dao.impl.UserInfoDaoImpl;
import lombok.extern.slf4j.Slf4j;
import service.RoomInfoService;
import service.RoomTypeService;

import java.util.*;
@Slf4j
public class RoomInfoServiceImpl implements RoomInfoService {
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private RoomTypeDao roomTypeDao = new RoomTypeDaoImpl();
    private RoomInfoDao roomInfoDao = new RoomInfoDaoImpl();
    @Override
    public List<Map<String, String>> queryRoomInfo(Map<String, Object> info, int index, int pageSize) {
        return roomInfoDao.queryRoomInfo(info,index,pageSize);
    }

    @Override
    public int updateRoomInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2) {
      
        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);
        if (result == null || result.isEmpty()) {
            log.error("更新room_info失败 : 未知操作人操作");
            return 0;
        }
        String room_type_id  = roomInfoDao.queryRoomInfo(info2).get(0).get("room_type_id");

        int temp = roomInfoDao.updateRoomInfo(info, info2);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对room_info表中条件是 %s 数据的字段更新为 %s ", info2.toString(), info.toString()));
        logInfo.put("time",new Date());
        if (temp > 0) {
            if ((info.containsKey("room_type_id"))&& (!room_type_id.equals(info.get("room_type_id")))) {

                Map<String, Object> roomTypeinfo = new HashMap<>();
                Map<String, Object> roomTypeinfo2 = new HashMap<>();
                roomTypeinfo2.put("room_type_id", info.get("room_type_id"));
                roomTypeinfo.put("number", Integer.parseInt(roomTypeDao.queryRoomType(roomTypeinfo2).get(0).get("number")) + 1);
                roomTypeDao.updateRoomType(roomTypeinfo, roomTypeinfo2);

                roomTypeinfo2.clear();
                roomTypeinfo.clear();
                roomTypeinfo2.put("room_type_id", room_type_id);
                roomTypeinfo.put("number", Integer.parseInt(roomTypeDao.queryRoomType(roomTypeinfo2).get(0).get("number")) - 1);
                roomTypeDao.updateRoomType(roomTypeinfo, roomTypeinfo2);
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
    public int insertRoomInfo(Map<String, Object> user, Map<String, Object> info) {
   
        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新room_info失败 : 未知操作人操作");
            return 0;
        }
        Map<String,Object> roomTypeinfo  = new HashMap<>();
        Map<String,Object> roomTypeinfo2  = new HashMap<>();
        roomTypeinfo2.put("room_type_id",info.get("room_type_id"));
        roomTypeinfo.put("number",Integer.parseInt(roomTypeDao.queryRoomType(roomTypeinfo2).get(0).get("number"))+1);

        int temp = roomInfoDao.insertRoomInfo(info);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对room_info表插入数据 %s ", info.toString()));
        logInfo.put("time",new Date());
        if (temp > 0) {
            roomTypeDao.updateRoomType(roomTypeinfo,roomTypeinfo2);
            logInfo.put("details", "操作成功");
            logInfoDao.insertLogInfo(logInfo);
            return 1;
        }
        logInfo.put("details", "操作失败");
        logInfoDao.insertLogInfo(logInfo);
        return 0;
    }

    @Override
    public int deleteRoomInfo(Map<String, Object> user, String info) {



        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);
        if (result == null || result.isEmpty()) {
            log.error("更新room_info失败 : 未知操作人操作");
            return 0;
        }
        Map<String, Object> roomTypeinfo = new HashMap<>();
        Map<String, Object> roomTypeinfo2 = new HashMap<>();
        Map<String, Object> delInfo = new HashMap<>();
        String[] strings = info.split(",");
        if (strings.length > 0) {
            for (String x : strings
            ) {
                delInfo.put("room_id", x);
                String status = roomInfoDao.queryRoomInfo(delInfo).get(0).get("status");
                if (!status.equals("空房"))return 0;
                roomTypeinfo2.put("room_type_id", roomInfoDao.queryRoomInfo(delInfo).get(0).get("room_type_id"));
                roomTypeinfo.put("number", Integer.parseInt(roomTypeDao.queryRoomType(roomTypeinfo2).get(0).get("number")) - 1);
                int temp = roomInfoDao.deleteRoomInfo(delInfo);

                Map<String, Object> logInfo = new LinkedHashMap<>();
                logInfo.put("user_id", user.get("user_id"));
                logInfo.put("operate", String.format("对room_info表条件是 %s 的数据进行删除  ", info.toString()));
                logInfo.put("time", new Date());
                if (temp > 0) {
                    roomTypeDao.updateRoomType(roomTypeinfo, roomTypeinfo2);
                    logInfo.put("details", "操作成功");
                    logInfoDao.insertLogInfo(logInfo);
                    continue;
                }
                logInfo.put("details", "操作失败");
                logInfoDao.insertLogInfo(logInfo);
                return 0;
            }
            return 1;
        }
        return 0;
    }

    @Override
    public int getRoomInfoCount(Map<String, Object> info) {
        return roomInfoDao.getRoomInfoCount(info);
    }

}
