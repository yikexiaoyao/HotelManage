package dao;

import java.util.List;
import java.util.Map;

public interface CostInfoDao {
	List<Map<String, String>> queryCostInfo(Map<String, Object> info);

	Float totalCost(Map<String, Object> info);

	List<Map<String, String>> queryCostInfo(Map<String, Object> info, int index, int pageSize);
	
	List<Map<String,String>> queryCostInfoByLike(Map<String, Object> info);


	int updateCostInfo(Map<String, Object> info, Map<String, Object> info2);
	
	int insertCostInfo(Map<String, Object> info);
	
	int deleteCostInfo(Map<String, Object> info);
	
	int getCostInfoCount(Map<String, Object> info);
}
