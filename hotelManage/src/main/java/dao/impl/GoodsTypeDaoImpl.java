package dao.impl;

import java.util.List;
import java.util.Map;

import dao.GoodsTypeDao;
import util.BootJDBCUtil;

public class GoodsTypeDaoImpl implements GoodsTypeDao {
	@Override
	public List<Map<String, String>> queryGoodsType(Map<String, Object> info) {
		return BootJDBCUtil.bootQueryInfo("goods_type",info);
	}

	@Override
	public List<Map<String, String>> queryGoodsType(Map<String, Object> info, int index, int pageSize) {
		return BootJDBCUtil.bootQueryInfo("goods_type",info,index,pageSize);
	}

	@Override
	public List<Map<String, String>> queryGoodsTypeByLike(Map<String, Object> info) {
		return BootJDBCUtil.bootQueryInfoByLike("goods_type",info);
	}

	@Override
	public int updateGoodsType(Map<String, Object> info, Map<String, Object> info2) {
		return BootJDBCUtil.bootUpdateInfo("goods_type",info,info2);
	}

	@Override
	public int insertGoodsType(Map<String, Object> info) {
		return BootJDBCUtil.bootInsertInfo("goods_type",info);
	}

	@Override
	public int deleteGoodsType(Map<String, Object> info) {
		return BootJDBCUtil.bootDelInfo("goods_type",info);
	}

	@Override
	public int getGoodsTypeCount(Map<String, Object> info) {
		return BootJDBCUtil.getCount("goods_type",info);
	}
}
