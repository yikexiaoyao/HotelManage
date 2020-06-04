package service.impl;

import dao.LogInfoDao;
import dao.MemberInfoDao;
import dao.UserInfoDao;
import dao.impl.LogInfoDaoImpl;
import dao.impl.MemberInfoDaoImpl;
import dao.impl.UserInfoDaoImpl;
import lombok.extern.slf4j.Slf4j;
import service.MemberInfoService;

import java.util.*;

@Slf4j
public class MemberInfoServiceImpl implements MemberInfoService {
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();
    private MemberInfoDao memberInfoDao = new MemberInfoDaoImpl();

    @Override
    public boolean login(Map<String, Object> info) {
        List<Map<String, String>> list = memberInfoDao.queryMemberInfo(info);
        if (list == null || list.isEmpty())
            return false;
        return true;
    }

    @Override
    public List<Map<String, String>> queryMemberInfoByLike(Map<String, Object> info) {
        return memberInfoDao.queryMemberInfoByLike(info);
    }

    @Override
    public List<Map<String, String>> queryMemberInfo(Map<String, Object> info, int index, int pageSize) {
        return memberInfoDao.queryMemberInfo(info, index, pageSize);
    }

    public int updateMemberInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2) {

        if (user.containsKey("authority")) {

            List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

            if (result == null || result.isEmpty()) {
                log.error("更新member_Info失败 : 未知操作人操作");
                return 0;
            }
            int temp = memberInfoDao.updateMemberInfo(info, info2);

            Map<String, Object> logInfo = new LinkedHashMap<>();
            logInfo.put("user_id", user.get("user_id"));
            logInfo.put("operate", String.format("对member_Info表中条件是 %s 数据的字段更新为 %s ", info2.toString(), info.toString()));
            logInfo.put("time", new Date());
            if (temp > 0) {
                logInfo.put("details", "操作成功");
                logInfoDao.insertLogInfo(logInfo);
                return 1;
            }
            logInfo.put("details", "操作失败");
            logInfoDao.insertLogInfo(logInfo);
        } else {
            return memberInfoDao.updateMemberInfo(info, info2);
        }
        return 0;

    }

    @Override
    public int insertMemberInfo(Map<String, Object> user, Map<String, Object> info) {
        if (user == null) {
            return memberInfoDao.insertMemberInfo(info);
        } else {
            List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

            if (result == null || result.isEmpty()) {
                log.error("更新member_Info失败 : 未知操作人操作");
                return 0;
            }
            int temp = memberInfoDao.insertMemberInfo(info);
            Map<String, Object> logInfo = new LinkedHashMap<>();
            logInfo.put("user_id", user.get("user_id"));
            logInfo.put("operate", String.format("对member_Info表插入数据 %s ", info.toString()));
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
    public int deleteMemberInfo(Map<String, Object> user, String info) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新member_Info失败 : 未知操作人操作");
            return 0;
        }
        Map<String, Object> delInfo = new HashMap<>();
        String[] strings = info.split(",");
        if (strings.length > 0) {
            for (String x : strings
            ) {

                delInfo.put("member_id", x);
                int temp = memberInfoDao.deleteMemberInfo(delInfo);
                Map<String, Object> logInfo = new LinkedHashMap<>();
                logInfo.put("user_id", user.get("user_id"));
                logInfo.put("operate", String.format("对member_Info表条件是 %s 的数据进行删除  ", info.toString()));
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
    public int getMemberInfoCount(Map<String, Object> info) {
        return memberInfoDao.getMemberInfoCount(info);
    }

}
