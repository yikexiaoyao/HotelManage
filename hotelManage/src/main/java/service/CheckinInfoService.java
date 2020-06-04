package service;

import java.util.List;
import java.util.Map;

public interface CheckinInfoService {

    List<Map<String, String>> queryRoomInfo(Map<String, Object> info, int index, int pageSize);
    List<Map<String, String>> queryCheckinCustomersInfo(Map<String, Object> info, int index, int pageSize);
    List<Map<String, String>> queryTodayLeaveCustomersInfo(Map<String, Object> info, int index, int pageSize);
    int insertCheckinInfo(Map<String,Object> user,Map<String, Object> info);

    List<Map<String, String>> queryCheckinInfo(Map<String, Object> info, int index, int pageSize);

    int getRoomInfoCount(Map<String, Object> info);

    int getCheckinInfoCount(Map<String, Object> info);
}
