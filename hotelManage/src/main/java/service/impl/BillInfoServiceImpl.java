package service.impl;

import dao.*;
import dao.impl.*;
import lombok.extern.slf4j.Slf4j;
import service.BillInfoService;

import java.util.*;

@Slf4j
public class BillInfoServiceImpl implements BillInfoService {

    private RoomInfoDao roomInfoDao = new RoomInfoDaoImpl();
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private CheckinInfoDao checkinInfoDao = new CheckinInfoDaoImpl();
    private LogInfoDao logInfoDao = new LogInfoDaoImpl();
    private BillInfoDao billInfoDao = new BillInfoDaoImpl();
    @Override
    public List<Map<String, String>> queryCheckinInfo(Map<String, Object> info, int index, int pageSize) {
        return checkinInfoDao.queryCheckinInfoIng(info,index,pageSize);
    }

    @Override
    public Map<String, Object> showCostInfo(Map<String, Object> info) {

        return billInfoDao.queryTotalCostInfo(info);
    }
    @Override
    public List<Map<String, String>> queryTodayBillInfoReportForm(Map<String, Object> info, int index, int pageSize) {
        return billInfoDao.queryTodayBillInfoReportForm(info,index,pageSize );
    }
    @Override
    public int insertBillInfo(Map<String, Object> user, Map<String, Object> info) {
        List<Map<String, String>> result = userInfoDao.queryUserInfo(user);

        if (result == null || result.isEmpty()) {
            log.error("更新bill_info失败 : 未知操作人操作");
            return 0;
        }
        info.put("return_deposit",info.get("deposit"));
        info.put("operator",user.get("user_id"));
        Map<String, Object> checkinInfo1 = new HashMap<>();
        Map<String, Object> checkinInfo2 = new HashMap<>();
        checkinInfo1.put("checkin_id",info.get("checkin_id"));
        checkinInfo2.put("leave_time",new Date());
        checkinInfoDao.updateCheckinInfo(checkinInfo2,checkinInfo1);


        int temp  = billInfoDao.insertBillInfo(info);
        Map<String, Object> logInfo = new LinkedHashMap<>();
        logInfo.put("user_id", user.get("user_id"));
        logInfo.put("operate", String.format("对bill_info表更新数据 %s ", info.toString()));
        logInfo.put("time",new Date());




        if (temp>0){
            Map<String,Object> roomInInfo = new HashMap<>();
            Map<String,Object> roomInInfo2 = new HashMap<>();
            roomInInfo.put("checkin_id",info.get("checkin_id"));
            roomInInfo.put("room_id",checkinInfoDao.queryCheckinInfo(roomInInfo).get(0).get("new_room_id"));
            roomInInfo.remove("checkin_id");
            roomInInfo2.put("status","空房");
            roomInfoDao.updateRoomInfo(roomInInfo2,roomInInfo);
            checkinInfoDao.updateCheckinInfo(checkinInfo2,checkinInfo1);
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

    @Override
    public int getBillInfoCount(Map<String, Object> info) {
        return billInfoDao.getBillInfoCount(info);
    }

    @Override
    public List<Map<String, String>> queryBillInfo(Map<String, Object> info, int index, int pageSize) {
        return billInfoDao.queryBillInfo(info,index,pageSize );
    }
}
