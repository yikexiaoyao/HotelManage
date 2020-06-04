package service.impl;

import dao.GoodsInfoDao;
import dao.GoodsTypeDao;
import dao.LogInfoDao;
import dao.UserInfoDao;
import dao.impl.GoodsInfoDaoImpl;
import dao.impl.GoodsTypeDaoImpl;
import dao.impl.LogInfoDaoImpl;
import dao.impl.UserInfoDaoImpl;
import lombok.extern.slf4j.Slf4j;
import service.GoodsInfoService;

import java.util.*;
@Slf4j
public class GoodsInfoServiceImpl  implements GoodsInfoService {
    private GoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
    @Override
    public List<Map<String, String>> queryGoodsInfo(Map<String, Object> info,int index,int pageSize) {
        return goodsInfoDao.queryGoodsInfo(info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryGoodsInfo(Map<String, Object> info) {
        return goodsInfoDao.queryGoodsInfo(info);
    }


    @Override
    public List<Map<String, String>> queryGoodsInfoByGoodType(String name, int index, int pageSize) {
        Map<String,Object> info = new HashMap<>();
        info.put("goods_type",name);
        info.put("type_id",goodsTypeDao.queryGoodsType(info).get(0).get("type_id"));
        info.remove("goods_type");
        return goodsInfoDao.queryGoodsInfo(info,index,pageSize);
    }

    @Override
    public int updateGoodsInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新goods_info失败 : 未知操作人操作");
            return 0;
        }
        int temp = goodsInfoDao.updateGoodsInfo(info, info2);

        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对goods_info表中条件是 %s 数据的字段更新为 %s ", info2.toString(), info.toString()));
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
    public int insertGoodsInfo(Map<String, Object> user, Map<String, Object> info) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新goods_info失败 : 未知操作人操作");
            return 0;
        }
        int temp = goodsInfoDao.insertGoodsInfo(info);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对goods_info表插入数据 %s ", info.toString()));
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
    public int deleteGoodsInfo(Map<String, Object> user, String info) {

        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新goods_info失败 : 未知操作人操作");
            return 0;
        }
        Map<String, Object> delInfo = new HashMap<>();
        String[] strings = info.split(",");
        if (strings.length > 0) {
            for (String x : strings
            ) {

                delInfo.put("goods_id", x);
                int temp = goodsInfoDao.deleteGoodsInfo(delInfo);
                Map<String, Object> logInfo = new LinkedHashMap<>();
                logInfo.put("user_id", user.get("user_id"));
                logInfo.put("operate", String.format("对goods_info表条件是 %s 的数据进行删除  ", info.toString()));
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
    public int getGoodsInfoCount(Map<String, Object> info) {
        return goodsInfoDao.getGoodsInfoCount(info);
    }
}
