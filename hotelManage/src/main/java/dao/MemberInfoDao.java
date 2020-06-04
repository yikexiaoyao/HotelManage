package dao;

import java.util.List;
import java.util.Map;

public interface MemberInfoDao {
	List<Map<String, String>> queryMemberInfo(Map<String, Object> info);

	List<Map<String, String>> queryMemberInfo(Map<String, Object> info, int index, int pageSize);
	
	List<Map<String,String>> queryMemberInfoByLike(Map<String, Object> info);


	int updateMemberInfo(Map<String, Object> info, Map<String, Object> info2);
	
	int insertMemberInfo(Map<String, Object> info);
	
	int deleteMemberInfo(Map<String, Object> info);
	
	int getMemberInfoCount(Map<String, Object> info);
}
