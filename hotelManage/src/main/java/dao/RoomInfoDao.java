package dao;

import java.util.List;
import java.util.Map;

public interface RoomInfoDao {
	List<Map<String, String>> queryRoomInfo(Map<String, Object> info);

	List<Map<String, String>> queryRoomInfo(Map<String, Object> info, int index, int pageSize);
	
	List<Map<String,String>> queryRoomInfoByLike(Map<String, Object> info);


	int updateRoomInfo(Map<String, Object> info, Map<String, Object> info2);
	
	int insertRoomInfo(Map<String, Object> info);
	
	int deleteRoomInfo(Map<String, Object> info);
	
	int getRoomInfoCount(Map<String, Object> info);
}
