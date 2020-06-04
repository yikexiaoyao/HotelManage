package dao;

import java.util.List;
import java.util.Map;

public interface GoodsTypeDao {
	List<Map<String, String>> queryGoodsType(Map<String, Object> info);

	List<Map<String, String>> queryGoodsType(Map<String, Object> info, int index, int pageSize);
	
	List<Map<String,String>> queryGoodsTypeByLike(Map<String, Object> info);


	int updateGoodsType(Map<String, Object> info, Map<String, Object> info2);
	
	int insertGoodsType(Map<String, Object> info);
	
	int deleteGoodsType(Map<String, Object> info);
	
	int getGoodsTypeCount(Map<String, Object> info);
}
