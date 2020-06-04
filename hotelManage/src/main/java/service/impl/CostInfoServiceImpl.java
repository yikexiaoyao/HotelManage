package service.impl;

import dao.*;
import dao.impl.*;
import lombok.extern.slf4j.Slf4j;
import service.CostInfoService;

import java.util.*;
@Slf4j
public class CostInfoServiceImpl implements CostInfoService {
    private GoodsInfoDao  goodsInfoDao = new GoodsInfoDaoImpl();
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();
    private CostInfoDao costInfoDao = new CostInfoDaoImpl();
    private MemberInfoDao memberInfoDao = new MemberInfoDaoImpl();
    private CheckinInfoDao checkinInfoDao = new CheckinInfoDaoImpl();


    @Override
    public List<Map<String, String>> queryGoodsInfo(Map<String, Object> info, int index, int pageSize) {
        return goodsInfoDao.queryGoodsInfo(info,index, pageSize);
    }

    @Override
    public List<Map<String, String>> queryCostInfo(Map<String, Object> info, int index, int pageSize) {
        return costInfoDao.queryCostInfo(info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryCostInfo(Map<String, Object> info) {
        return costInfoDao.queryCostInfo(info);
    }

    @Override
    public Float getTotalCost(Map<String, Object> info) {
        return costInfoDao.totalCost(info);
    }

    @Override
    public int updateCostInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2) {

        List<Map<String, String>> userInfo = userInfoDao.queryUserInfo(user);

        Map<String, String> costInfo = costInfoDao.queryCostInfo(info2).get(0);
        Map<String, Object> tempInfo = new HashMap<>();
        tempInfo.put("checkin_id",costInfo.get("checkin_id"));
        Map<String, String > checkinInfo = checkinInfoDao.queryCheckinInfo(tempInfo).get(0);


        if (userInfo == null || userInfo.isEmpty()) {
            log.error("更新cost_info失败 : 未知操作人操作");
            return 0;
        }
        info.put("operator",user.get("user_id"));
        info.put("time",new Date());
        int temp = costInfoDao.updateCostInfo(info, info2);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对cost_info表中条件是 %s 数据的字段更新为 %s ", info2.toString(), info.toString()));
        logInfo.put("time",new Date());
        if (temp > 0) {
            if (checkinInfo.containsKey("member_id")&&(info.containsKey("goods_id")||info.containsKey("number"))){

                Float cost = costInfoDao.totalCost(tempInfo);

                tempInfo.clear();
                tempInfo.put("member_id",checkinInfo.get("member_id"));
                Map<String,Object> tempInfo2 = new HashMap<>();
                tempInfo2.put("integral",cost);
                if (cost>=5000){
                    tempInfo2.put("level","vip");
                }else {
                    tempInfo2.put("level","member");
                }
                memberInfoDao.updateMemberInfo(tempInfo2,tempInfo);
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
    public int insertCostInfo( Map<String, Object> user,Map<String, Object> info) {
        List<Map<String, String>> userInfo = userInfoDao.queryUserInfo(user);

        Map<String, Object> tempInfo = new HashMap<>();
        tempInfo.put("checkin_id",info.get("checkin_id"));
        Map<String, String > checkinInfo = checkinInfoDao.queryCheckinInfo(tempInfo).get(0);

        if (userInfo == null || userInfo.isEmpty()) {
            log.error("更新cost_info失败 : 未知操作人操作");
            return 0;
        }
        info.put("operator",user.get("user_id"));
        info.put("time",new Date());
        int temp =costInfoDao.insertCostInfo(info);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对cost_info表条件是 %s 的数据进行删除  ", info.toString()));
        logInfo.put("time",new Date());

        if(temp>0){
            if (checkinInfo.containsKey("member_id")){
                Float cost = costInfoDao.totalCost(tempInfo);

                tempInfo.clear();
                tempInfo.put("member_id",checkinInfo.get("member_id"));
                Map<String,Object> tempInfo2 = new HashMap<>();
                tempInfo2.put("integral",cost);
                if (cost>=5000){
                    tempInfo2.put("level","vip");
                }else {
                    tempInfo2.put("level","member");
                }
                memberInfoDao.updateMemberInfo(tempInfo2,tempInfo);
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
    public int deleteCostInfo(Map<String, Object> user, String info) {

        List<Map<String, String>> userInfo = userInfoDao.queryUserInfo(user);

        if (userInfo == null || userInfo.isEmpty()) {
            log.error("更新cost_info失败 : 未知操作人操作");
            return 0;
        }
        Map<String, Object> delInfo = new HashMap<>();
        String[] strings = info.split(",");
        if (strings.length > 0) {
            for (String x : strings
            ) {

                delInfo.put("cost_id", x);
                int temp = costInfoDao.deleteCostInfo(delInfo);
                Map<String, Object> logInfo = new LinkedHashMap<>();
                logInfo.put("user_id", user.get("user_id"));
                logInfo.put("operate", String.format("对cost_info表条件是 %s 的数据进行删除  ", info.toString()));
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
    public int getCostInfoCount(Map<String, Object> info) {
        return costInfoDao.getCostInfoCount(info);
    }

    @Override
    public int getGoodsInfoCount(Map<String, Object> info) {
        return goodsInfoDao.getGoodsInfoCount(info);
    }
}
