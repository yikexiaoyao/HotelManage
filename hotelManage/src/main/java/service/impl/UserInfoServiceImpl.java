package service.impl;

import dao.LogInfoDao;
import dao.UserInfoDao;
import dao.impl.LogInfoDaoImpl;
import dao.impl.UserInfoDaoImpl;
import lombok.extern.slf4j.Slf4j;
import service.UserInfoService;

import java.util.*;

@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();

    @Override
    public boolean login(Map<String, Object> info) {
        List<Map<String, String>> list = userInfoDao.queryUserInfo(info);
        if (list == null || list.isEmpty())
            return false;
        return true;
    }

    @Override
    public List<Map<String, String>> queryUserInfoByLike(Map<String, Object> info) {
        return userInfoDao.queryUserInfoByLike(info);
    }

    @Override
    public List<Map<String, String>> queryUserInfo(Map<String, Object> info, int index, int pageSize) {
        return userInfoDao.queryUserInfo(info, index, pageSize);
    }

    public int updateUserInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2) {

 
        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新user_info失败 : 未知操作人操作");
            return 0;
        }
        int temp = userInfoDao.updateUserInfo(info, info2);

        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对user_info表中条件是 %s 数据的字段更新为 %s ", info2.toString(), info.toString()));
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
    public int insertUserInfo(Map<String, Object> user, Map<String, Object> info) {
        if (user == null) {
            return userInfoDao.insertUserInfo(info);
        } else {
            List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

            if (result == null || result.isEmpty()) {
                log.error("更新user_info失败 : 未知操作人操作");
                return 0;
            }
            int temp = userInfoDao.insertUserInfo(info);
            Map<String, Object> logInfo = new LinkedHashMap<>();
            logInfo.put("user_id", user.get("user_id"));
            logInfo.put("operate", String.format("对user_info表插入数据 %s ", info.toString()));
            logInfo.put("time", new Date());
            if (temp > 0) {
                logInfo.put("details", "操作成功");
                logInfoDao.insertLogInfo(logInfo);
                return 1;
            }
            logInfo.put("details", "操作失败");
            logInfoDao.insertLogInfo(logInfo);
        }
        return 0;
    }

    @Override
    public int deleteUserInfo(Map<String, Object> user, String  info) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新user_info失败 : 未知操作人操作");
            return 0;
        }
        Map<String, Object> delInfo = new HashMap<>();
        String[] strings = info.split(",");
        if (strings.length > 0) {
            for (String x : strings
            ) {
                delInfo.put("user_id", x);
                int temp = userInfoDao.deleteUserInfo(delInfo);
                Map<String, Object> logInfo = new LinkedHashMap<>();
                logInfo.put("user_id", user.get("user_id"));
                logInfo.put("operate", String.format("对user_info表条件是 %s 的数据进行删除  ", info.toString()));
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
        }return 0;
    }


    @Override
    public int getUserInfoCount(Map<String, Object> info) {
        return userInfoDao.getUserInfoCount(info);
    }
}
