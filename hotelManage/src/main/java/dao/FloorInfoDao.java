package dao;

import java.util.List;
import java.util.Map;

public interface FloorInfoDao {
	List<Map<String, String>> queryFloorInfo(Map<String, Object> info);

	List<Map<String, String>> queryFloorInfo(Map<String, Object> info, int index, int pageSize);
	
	List<Map<String,String>> queryFloorInfoByLike(Map<String, Object> info);


	int updateFloorInfo(Map<String, Object> info, Map<String, Object> info2);
	
	int insertFloorInfo(Map<String, Object> info);
	
	int deleteFloorInfo(Map<String, Object> info);
	
	int getFloorInfoCount(Map<String, Object> info);
}
