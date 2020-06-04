package dao;

import java.util.List;
import java.util.Map;

public interface LogInfoDao {
	List<Map<String, String>> queryLogInfo(Map<String, Object> info);

	List<Map<String, String>> queryLogInfo(Map<String, Object> info, int index, int pageSize);

	List<Map<String,String>> queryLogInfoByLike(Map<String, Object> info);


	int updateLogInfo(Map<String, Object> info, Map<String, Object> info2);

	int insertLogInfo(Map<String, Object> info);

	int deleteLogInfo(Map<String, Object> info);

	int getLogInfoCount(Map<String, Object> info);
}
