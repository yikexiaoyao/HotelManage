package dao;

import java.util.List;
import java.util.Map;

public interface RoomTypeDao {
	List<Map<String, String>> queryRoomType(Map<String, Object> info);

	List<Map<String, String>> queryRoomType(Map<String, Object> info, int index, int pageSize);
	
	List<Map<String,String>> queryRoomTypeByLike(Map<String, Object> info);


	int updateRoomType(Map<String, Object> info, Map<String, Object> info2);
	
	int insertRoomType(Map<String, Object> info);
	
	int deleteRoomType(Map<String, Object> info);
	
	int getRoomTypeCount(Map<String, Object> info);
}
