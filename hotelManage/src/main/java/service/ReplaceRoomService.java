package service;

import java.util.List;
import java.util.Map;

public interface ReplaceRoomService {

    List<Map<String, String>> queryCheckinInfo(Map<String, Object> info, int index, int pageSize);

    int updateCheckinInfo(Map<String,Object> user,Map<String, Object> info,Map<String, Object> info2);

    int getCheckinInfoCount(Map<String, Object> info);

}
