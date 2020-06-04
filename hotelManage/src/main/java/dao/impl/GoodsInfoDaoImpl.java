package dao.impl;


import util.BootJDBCUtil;

import java.util.List;
import java.util.Map;

public class GoodsInfoDaoImpl implements dao.GoodsInfoDao {
    @Override
    public List<Map<String, String>> queryGoodsInfo(Map<String, Object> info) {

        return BootJDBCUtil.bootQueryInfo("goods_info",info);
    }

    @Override
    public List<Map<String, String>> queryGoodsInfo(Map<String, Object> info, int index, int pageSize) {

        String sql = "SELECT *,goods_info.details FROM goods_info,goods_type where goods_info.type_id = goods_type.type_id";

        return BootJDBCUtil.bootQueryInfoLink(sql,"goods_info",info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryGoodsInfoByLike(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfoByLike("goods_info",info);
    }

    @Override
    public int updateGoodsInfo(Map<String, Object> info, Map<String, Object> info2) {
        return BootJDBCUtil.bootUpdateInfo("goods_info",info,info2);
    }

    @Override
    public int insertGoodsInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootInsertInfo("goods_info",info);
    }

    @Override
    public int deleteGoodsInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootDelInfo("goods_info",info);
    }

    @Override
    public int getGoodsInfoCount(Map<String, Object> info) {
        return BootJDBCUtil.getCount("goods_info",info);
    }
}
