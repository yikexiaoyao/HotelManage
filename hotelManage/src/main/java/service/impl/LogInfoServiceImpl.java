package service.impl;

import dao.LogInfoDao;
import dao.UserInfoDao;
import dao.impl.LogInfoDaoImpl;
import dao.impl.UserInfoDaoImpl;
import lombok.extern.slf4j.Slf4j;
import service.LogInfoService;

import java.util.*;

@Slf4j
public class LogInfoServiceImpl implements LogInfoService {

    private LogInfoDao logInfoDao = new LogInfoDaoImpl();
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();

    @Override
    public List<Map<String, String>> queryLogInfo(Map<String, Object> info, int index, int pageSize) {
        return logInfoDao.queryLogInfo(info,index,pageSize);
    }

    @Override
    public int deleteLogInfo(Map<String, Object> user, Map<String, Object> info) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("删除LogInfo信息失败 : 未知操作人操作");
            return 0;
        }
        if (info.containsKey("log_id")) {
            Map<String, Object> delInfo = new HashMap<>();
            String[] strings = ((String) info.get("log_id")).split(",");
            if (strings.length > 0) {
                for (String x : strings
                ) {
                    delInfo.put("log_id", x);
                    int temp = logInfoDao.deleteLogInfo(delInfo);
                    Map<String, Object> logInfo = new LinkedHashMap<>();
                    logInfo.put("user_id", user.get("user_id"));
                    logInfo.put("operate", String.format("对log_info表条件是 %s 的数据进行删除  ", info.toString()));
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
        }
        int temp = logInfoDao.deleteLogInfo(info);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对log_info表条件是 %s 的数据进行删除  ", info.toString()));
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
    public int getLogInfoCount(Map<String, Object> info) {
        return logInfoDao.getLogInfoCount(info);
    }
}
