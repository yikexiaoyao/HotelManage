package dao.impl;

import dao.CostInfoDao;
import util.BootJDBCUtil;

import java.util.List;
import java.util.Map;

public class CostInfoDaoImpl implements CostInfoDao {

    @Override
    public List<Map<String, String>> queryCostInfo(Map<String, Object> info) {
        String sql = "SELECT * ,  number*goods_info.discount,cost_info.details as 'total' FROM cost_info,goods_info WHERE cost_info.goods_id= goods_info.goods_id";
        return BootJDBCUtil.bootQueryInfoLink(sql,"cost_info",info);
    }

    @Override
    public Float totalCost(Map<String, Object> info) {
        String sql = "SELECT SUM(number*goods_info.discount) as 'cost' FROM `cost_info`,goods_info where cost_info.goods_id = goods_info.goods_id";
        List<Map<String, String>> temp = BootJDBCUtil.bootQueryInfoLink(sql,"cost_info",info);
        if (temp==null||temp.isEmpty()){
            return 0f;
        }
        return Float.parseFloat(temp.get(0).get("cost"));
    }

    @Override
    public List<Map<String, String>> queryCostInfo(Map<String, Object> info, int index, int pageSize) {
        String sql = "SELECT * ,cost_info.details,number*goods_info.discount as 'total' FROM cost_info,goods_info WHERE cost_info.goods_id= goods_info.goods_id";
        return BootJDBCUtil.bootQueryInfoLink(sql,"cost_info",info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryCostInfoByLike(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfoByLike("cost_info",info);
    }

    @Override
    public int updateCostInfo(Map<String, Object> info, Map<String, Object> info2) {
        return BootJDBCUtil.bootUpdateInfo("cost_info",info,info2);
    }

    @Override
    public int insertCostInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootInsertInfo("cost_info",info);
    }

    @Override
    public int deleteCostInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootDelInfo("cost_info",info);
    }

    @Override
    public int getCostInfoCount(Map<String, Object> info) {
        return BootJDBCUtil.getCount("cost_info",info);
    }
}
