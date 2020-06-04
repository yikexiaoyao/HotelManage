package service;

import java.util.List;
import java.util.Map;

public interface RoomTypeService {

    List<Map<String, String>> queryRoomType(Map<String, Object> info);
    List<Map<String,String>> queryRoomTypeByLike(Map<String, Object> info);


    List<Map<String, String>> queryRoomType(Map<String, Object> info, int index, int pageSize);

    int updateRoomType(Map<String, Object> user,Map<String, Object> info, Map<String, Object> info2);

    int insertRoomType(Map<String, Object> user,Map<String, Object> info);

    int deleteRoomType(Map<String, Object> user,String info);

    int getRoomTypeCount(Map<String, Object> info);
}
