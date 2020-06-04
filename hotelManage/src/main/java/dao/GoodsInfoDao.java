package dao;

import java.util.List;
import java.util.Map;

public interface GoodsInfoDao {
	List<Map<String, String>> queryGoodsInfo(Map<String, Object> info);

	List<Map<String, String>> queryGoodsInfo(Map<String, Object> info, int index, int pageSize);
	
	List<Map<String,String>> queryGoodsInfoByLike(Map<String, Object> info);


	int updateGoodsInfo(Map<String, Object> info, Map<String, Object> info2);
	
	int insertGoodsInfo(Map<String, Object> info);
	
	int deleteGoodsInfo(Map<String, Object> info);
	
	int getGoodsInfoCount(Map<String, Object> info);
}
