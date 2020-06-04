package dao.impl;

import dao.RoomTypeDao;
import util.BootJDBCUtil;

import java.util.List;
import java.util.Map;

public class RoomTypeDaoImpl implements RoomTypeDao {
    @Override
    public List<Map<String, String>> queryRoomType(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfo("room_type",info);
    }

    @Override
    public List<Map<String, String>> queryRoomType(Map<String, Object> info, int index, int pageSize) {
        return BootJDBCUtil.bootQueryInfo("room_type",info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryRoomTypeByLike(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfoByLike("room_type",info);
    }

    @Override
    public int updateRoomType(Map<String, Object> info, Map<String, Object> info2) {
        return BootJDBCUtil.bootUpdateInfo("room_type",info,info2);
    }

    @Override
    public int insertRoomType(Map<String, Object> info) {
        return BootJDBCUtil.bootInsertInfo("room_type",info);
    }

    @Override
    public int deleteRoomType(Map<String, Object> info) {
        return BootJDBCUtil.bootDelInfo("room_type",info);
    }

    @Override
    public int getRoomTypeCount(Map<String, Object> info) {
        return BootJDBCUtil.getCount("room_type",info);
    }
}
