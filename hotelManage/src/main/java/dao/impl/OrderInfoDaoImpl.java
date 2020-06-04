package dao.impl;

import util.BootJDBCUtil;

import java.util.List;
import java.util.Map;

public class OrderInfoDaoImpl implements dao.OrderInfoDao {

    @Override
    public List<Map<String, String>> queryBookCustomersInfo(Map<String, Object> info, int index, int pageSize) {
        //如果不想取这么多order_info表的字段，就用a.xxx,a.xxx过滤,其他的报表查询都一样
//        String sql = "SELECT b.type , a.order_id,a.xxxx,a.xxx FROM order_info a , room_type b , room_info c WHERE b.room_type_id = c.room_type_id";

        String startDate = (String) info.get("startDate");
        String endDate = (String) info.get("endDate");
        String today =  (String) info.get("todayDate");

        String sql;
        if (startDate != null && startDate.length() > 0 && endDate != null && endDate.length() > 0) {
            sql = "SELECT b.type , a.* FROM order_info a , room_type b , room_info c WHERE a.room_id = c.room_id and b.room_type_id = c.room_type_id and a.arrivals_tima >= '" + startDate + "' and a.arrivals_tima <= '" + endDate + "'";
            info.remove("startDate");
            info.remove("endDate");
        } else if (today != null && today.length() > 0 ){
            sql = "SELECT b.type , a.* FROM order_info a , room_type b , room_info c WHERE a.room_id = c.room_id and b.room_type_id = c.room_type_id and DATE_FORMAT(arrivals_time,\"%Y-%m-%d\") = '" + today + "'";
            info.remove("todayDate");
        }else {
            sql = "SELECT b.type , a.* FROM order_info a , room_type b , room_info c WHERE a.room_id = c.room_id and b.room_type_id = c.room_type_id";
        }
        return BootJDBCUtil.bootQueryInfoLink(sql, "a", info);
    }

    @Override
    public List<Map<String, String>> queryOrderInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfo("order_info",info);
    }

    @Override
    public List<Map<String, String>> queryOrderInfo(Map<String, Object> info, int index, int pageSize) {
        String sql = "SELECT *,order_info.details FROM order_info ,room_info,room_type  where order_info.room_id = room_info.room_id and room_info.room_type_id = room_type.room_type_id";
        if (info.containsKey("room_type_id")){
            sql+=" and room_type.room_type_id="+info.get("room_type_id");
            info.remove("room_type_id");
        }
        return BootJDBCUtil.bootQueryInfoLink(sql,"order_info",info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryOrderInfoByLike(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfoByLike("order_info",info);
    }

    @Override
    public int updateOrderInfo(Map<String, Object> info, Map<String, Object> info2) {
        return BootJDBCUtil.bootUpdateInfo("order_info",info,info2);
    }

    @Override
    public int insertOrderInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootInsertInfo("order_info",info);
    }

    @Override
    public int deleteOrderInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootDelInfo("order_info",info);
    }

    @Override
    public int getOrderInfoCount(Map<String, Object> info) {
        return BootJDBCUtil.getCount("order_info",info);
    }
}
