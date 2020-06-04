package dao.impl;

import dao.CheckinInfoDao;
import util.BootJDBCUtil;

import java.util.List;
import java.util.Map;

public class CheckinInfoDaoImpl implements CheckinInfoDao {
    @Override
    public List<Map<String, String>> queryCheckinInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfo("checkin_info",info);
    }
    @Override
    public List<Map<String, String>> queryCheckinCustomersInfo(Map<String, Object> info, int index, int pageSize) {
        String startDate = (String) info.get("startDate");
        String endDate = (String) info.get("endDate");
        String today = (String) info.get("todayDate");

        String sql;
        if (startDate != null && startDate.length() > 0 && endDate != null && endDate.length() > 0) {
            sql = "SELECT b.type , a.* FROM checkin_info a , room_type b , room_info c WHERE a.new_room_id = c.room_id and b.room_type_id = c.room_type_id and a.arrivals_tima >= '" + startDate + "' and a.arrivals_tima <= '" + endDate + "'";
            info.remove("startDate");
            info.remove("endDate");
        } else if (today != null && today.length() > 0) {
            sql = "SELECT b.type , a.* FROM checkin_info a , room_type b , room_info c WHERE a.new_room_id = c.room_id and b.room_type_id = c.room_type_id and DATE_FORMAT(a.arrivals_time,\"%Y-%m-%d\") = '" + today + "'";
            info.remove("todayDate");
        } else {
            sql = "SELECT b.type , a.* FROM checkin_info a , room_type b , room_info c WHERE a.new_room_id = c.room_id and b.room_type_id = c.room_type_id";
        }
        return BootJDBCUtil.bootQueryInfoLink(sql, "a", info);
    }

    public List<Map<String, String>> queryCheckinCustomersInfo1(Map<String, Object> info, int index, int pageSize) {
        String today = (String) info.get("todayDate");
        String sql;
        if (today != null && today.length() > 0) {
            sql = "SELECT b.type , a.* FROM checkin_info a , room_type b , room_info c WHERE a.new_room_id = c.room_id and b.room_type_id = c.room_type_id and DATE_FORMAT(a.leave_time,\"%Y-%m-%d\") = '" + today + "'";
            info.remove("todayDate");
        } else {
            sql = "SELECT b.type , a.* FROM checkin_info a , room_type b , room_info c WHERE a.new_room_id = c.room_id and b.room_type_id = c.room_type_id";
        }
        return BootJDBCUtil.bootQueryInfoLink(sql, "a", info);
    }


    @Override
    public List<Map<String, String>> queryCheckinInfoIng(Map<String, Object> info, int index, int pageSize) {
        String sql = "SELECT * FROM checkin_info,room_info,room_type where checkin_info.new_room_id=room_info.room_id and room_info.room_type_id = room_type.room_type_id and NOW()<leave_time";
        return BootJDBCUtil.bootQueryInfoLink(sql,"checkin_info",info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryCheckinInfoByLike(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfoByLike("checkin_info",info);
    }

    @Override
    public int updateCheckinInfo(Map<String, Object> info, Map<String, Object> info2) {
        return BootJDBCUtil.bootUpdateInfo("checkin_info",info,info2);
    }

    @Override
    public int insertCheckinInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootInsertInfo("checkin_info",info);
    }

    @Override
    public int deleteCheckinInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootDelInfo("checkin_info",info);
    }

    @Override
    public int getCheckinInfoCount(Map<String, Object> info) {
        String sql = "SELECT count(1) FROM checkin_info,room_info,room_type where checkin_info.new_room_id=room_info.room_id and room_info.room_type_id = room_type.room_type_id and NOW()<leave_time";
        return Integer.parseInt(BootJDBCUtil.bootQueryInfoLink(sql,"checkin_info",info).get(0).get("count(1)"));
    }
}
