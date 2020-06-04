package service.impl;

import dao.LogInfoDao;
import dao.RoomTypeDao;
import dao.UserInfoDao;
import dao.impl.LogInfoDaoImpl;
import dao.impl.RoomTypeDaoImpl;
import dao.impl.UserInfoDaoImpl;
import lombok.extern.slf4j.Slf4j;
import service.RoomTypeService;


import java.util.*;

@Slf4j
public class RoomTypeServiceImpl implements RoomTypeService {

    private RoomTypeDao roomTypeDao = new RoomTypeDaoImpl();
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();

    @Override
    public List<Map<String, String>> queryRoomType(Map<String, Object> info) {

        return roomTypeDao.queryRoomType(info);
    }

    @Override
    public List<Map<String, String>> queryRoomType(Map<String, Object> info, int index, int pageSize) {
        return roomTypeDao.queryRoomType(info, index, pageSize);
    }

    @Override
    public List<Map<String, String>> queryRoomTypeByLike(Map<String, Object> info) {
        return roomTypeDao.queryRoomTypeByLike(info);
    }

    @Override
    public int updateRoomType(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新RoomType失败 : 未知操作人操作");
            return 0;
        }
        int temp = roomTypeDao.updateRoomType(info, info2);

        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对room_type表中条件是 %s 数据的字段更新为 %s ", info2.toString(), info.toString()));
        logInfo.put("time", new Date());
        if (temp > 0) {
            logInfo.put("details", "操作成功");
            logInfoDao.insertLogInfo(logInfo);
            return 1;
        }
        logInfo.put("details", "操作失败");
        logInfoDao.insertLogInfo(logInfo);
        return 0;

    }

    @Override
    public int insertRoomType(Map<String, Object> user, Map<String, Object> info) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("插入RoomType失败 : 未知操作人操作");
            return 0;
        }
        int temp = roomTypeDao.insertRoomType(info);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对room_type表插入数据 %s ", info.toString()));
        logInfo.put("time", new Date());
        if (temp > 0) {
            logInfo.put("details", "操作成功");
            logInfoDao.insertLogInfo(logInfo);
            return 1;
        }
        logInfo.put("details", "操作失败");
        logInfoDao.insertLogInfo(logInfo);
        return 0;
    }

    @Override
    public int deleteRoomType(Map<String, Object> user, String info) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);


        if (result == null || result.isEmpty()) {
            log.error("插入RoomType失败 : 未知操作人操作");
            return 0;
        }
        Map<String, Object> delInfo = new HashMap<>();
        String[] strings = info.split(",");
        if (strings.length > 0) {
            for (String x : strings
            ) {

                delInfo.put("room_type_id", x);
                int temp = roomTypeDao.deleteRoomType(delInfo);
                Map<String, Object> logInfo = new LinkedHashMap<>();
                logInfo.put("user_id", user.get("user_id"));
                logInfo.put("operate", String.format("对room_type表条件是 %s 的数据进行删除  ", info.toString()));
                logInfo.put("time", new Date());
                if (temp > 0) {
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
    public int getRoomTypeCount(Map<String, Object> info) {
        return roomTypeDao.getRoomTypeCount(info);
    }
}
