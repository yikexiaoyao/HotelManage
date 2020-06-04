package dao.impl;

import dao.RoomInfoDao;
import util.BootJDBCUtil;

import java.util.List;
import java.util.Map;

public class RoomInfoDaoImpl implements RoomInfoDao {
    @Override
    public List<Map<String, String>> queryRoomInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfo("room_info",info);
    }

    @Override
    public List<Map<String, String>> queryRoomInfo(Map<String, Object> info, int index, int pageSize) {
        String sql = "SELECT *,room_info.details FROM room_info,room_type,floor_info where room_info.room_type_id=room_type.room_type_id and room_info.floor_id = floor_info.floor_id";

        if(info.containsKey("discounted_price")){
            String temp1  =  (String)info.get("discounted_price");
            Float[] temp = new Float[]{Float.valueOf(temp1.split(",")[0]), Float.valueOf(temp1.split(",")[1])};
            sql +=" and discounted_price BETWEEN "+temp[0]+" and "+temp[1];
            info.remove("discounted_price");
        }
        if(info.containsKey("price")) {
            String temp1  =  (String)info.get("price");
            Float[] temp = new Float[]{Float.valueOf(temp1.split(",")[0]), Float.valueOf(temp1.split(",")[1])};
            sql +=" and price BETWEEN "+temp[0]+" and "+temp[1];
            info.remove("price");
        }
        if (info.containsKey("member_price")){
            String temp1  =  (String)info.get("member_price");
            Float[] temp = new Float[]{Float.valueOf(temp1.split(",")[0]), Float.valueOf(temp1.split(",")[1])};
            sql +=" and member_price BETWEEN "+temp[0]+" and "+temp[1];
            info.remove("member_price");
        }
        if (info.containsKey("vip_price")){
            String temp1  =  (String)info.get("vip_price");
            Float[] temp = new Float[]{Float.valueOf(temp1.split(",")[0]), Float.valueOf(temp1.split(",")[1])};
            sql +=" and vip_price BETWEEN "+temp[0]+" and "+temp[1];
            info.remove("vip_price");
        }
           return BootJDBCUtil.bootQueryInfoLink(sql,"room_info",info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryRoomInfoByLike(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfoByLike("room_info",info);
    }

    @Override
    public int updateRoomInfo(Map<String, Object> info, Map<String, Object> info2) {
        return BootJDBCUtil.bootUpdateInfo("room_info",info,info2);
    }

    @Override
    public int insertRoomInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootInsertInfo("room_info",info);
    }

    @Override
    public int deleteRoomInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootDelInfo("room_info",info);
    }

    @Override
    public int getRoomInfoCount(Map<String, Object> info) {
        return BootJDBCUtil.getCount("room_info",info);
    }
}
