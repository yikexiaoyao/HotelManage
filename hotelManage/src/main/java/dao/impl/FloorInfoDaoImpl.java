package dao.impl;

import util.BootJDBCUtil;

import java.util.List;
import java.util.Map;

public class FloorInfoDaoImpl implements dao.FloorInfoDao {
    @Override
    public List<Map<String, String>> queryFloorInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfo("floor_info",info);
    }

    @Override
    public List<Map<String, String>> queryFloorInfo(Map<String, Object> info, int index, int pageSize) {
        return BootJDBCUtil.bootQueryInfo("floor_info",info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryFloorInfoByLike(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfoByLike("floor_info",info);
    }

    @Override
    public int updateFloorInfo(Map<String, Object> info, Map<String, Object> info2) {
        return BootJDBCUtil.bootUpdateInfo("floor_info",info,info2);
    }

    @Override
    public int insertFloorInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootInsertInfo("floor_info",info);
    }

    @Override
    public int deleteFloorInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootDelInfo("floor_info",info);
    }

    @Override
    public int getFloorInfoCount(Map<String, Object> info) {
        return BootJDBCUtil.getCount("floor_info",info);
    }
}
