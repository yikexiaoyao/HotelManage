package dao;

import java.util.List;
import java.util.Map;

public interface CheckinInfoDao {
	List<Map<String, String>> queryCheckinInfo(Map<String, Object> info);
	List<Map<String, String>> queryCheckinCustomersInfo1(Map<String, Object> info, int index, int pageSize);
	List<Map<String, String>> queryCheckinCustomersInfo(Map<String, Object> info, int index, int pageSize);
	List<Map<String, String>> queryCheckinInfoIng(Map<String, Object> info, int index, int pageSize);

	List<Map<String,String>> queryCheckinInfoByLike(Map<String, Object> info);


	int updateCheckinInfo(Map<String, Object> info, Map<String, Object> info2);

	int insertCheckinInfo(Map<String, Object> info);

	int deleteCheckinInfo(Map<String, Object> info);

	int getCheckinInfoCount(Map<String, Object> info);
}
