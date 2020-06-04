package service.impl;

import dao.FloorInfoDao;
import dao.LogInfoDao;
import dao.UserInfoDao;
import dao.impl.FloorInfoDaoImpl;
import dao.impl.LogInfoDaoImpl;
import dao.impl.UserInfoDaoImpl;
import lombok.extern.slf4j.Slf4j;
import service.FloorInfoService;

import java.util.*;

@Slf4j
public class FloorInfoServiceImpl implements FloorInfoService {
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private FloorInfoDao floorInfoDao = new FloorInfoDaoImpl();
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();

    @Override
    public List<Map<String, String>> queryFloorInfo(Map<String, Object> info,int index,int pageSize) {
        return floorInfoDao.queryFloorInfo(info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryFloorInfo(Map<String, Object> info) {
        return floorInfoDao.queryFloorInfo(info);
    }

    @Override
    public int updateFloorInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新floor_info失败 : 未知操作人操作");
            return 0;
        }
        int temp = floorInfoDao.updateFloorInfo(info, info2);

        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对floor_info表中条件是 %s 数据的字段更新为 %s ", info2.toString(), info.toString()));
        logInfo.put("time",new Date());
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
    public int insertFloorInfo(Map<String, Object> user, Map<String, Object> info) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新floor_info失败 : 未知操作人操作");
            return 0;
        }
        int temp = floorInfoDao.insertFloorInfo(info);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对floor_info表插入数据 %s ", info.toString()));
        logInfo.put("time",new Date());
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
    public int deleteFloorInfo(Map<String, Object> user, String info) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新floor_info失败 : 未知操作人操作");
            return 0;
        }
        Map<String, Object> delInfo = new HashMap<>();
        String[] strings = info.split(",");
        if (strings.length > 0) {
            for (String x : strings
            ) {

                delInfo.put("floor_id", x);
                int temp = floorInfoDao.deleteFloorInfo(delInfo);
                Map<String, Object> logInfo = new LinkedHashMap<>();
                logInfo.put("user_id", user.get("user_id"));
                logInfo.put("operate", String.format("对floor_info表条件是 %s 的数据进行删除  ", info.toString()));
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
    public int getFloorInfoCount(Map<String, Object> info) {
        return floorInfoDao.getFloorInfoCount(info);
    }
}
