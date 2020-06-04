package dao;

import java.util.List;
import java.util.Map;

public interface UserInfoDao {
	List<Map<String, String>> queryUserInfo(Map<String, Object> info);

	List<Map<String, String>> queryUserInfo(Map<String, Object> info, int index, int pageSize);
	
	List<Map<String,String>> queryUserInfoByLike(Map<String, Object> info);


	int updateUserInfo(Map<String, Object> info, Map<String, Object> info2);
	
	int insertUserInfo(Map<String, Object> info);
	
	int deleteUserInfo(Map<String, Object> info);
	
	int getUserInfoCount(Map<String, Object> info);
}
