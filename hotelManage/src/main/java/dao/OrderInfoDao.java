package dao;

import java.util.List;
import java.util.Map;

public interface OrderInfoDao {
	List<Map<String, String>> queryBookCustomersInfo(Map<String, Object> info, int index, int pageSize);
	List<Map<String, String>> queryOrderInfo(Map<String, Object> info);

	List<Map<String, String>> queryOrderInfo(Map<String, Object> info, int index, int pageSize);

	List<Map<String,String>> queryOrderInfoByLike(Map<String, Object> info);


	int updateOrderInfo(Map<String, Object> info, Map<String, Object> info2);

	int insertOrderInfo(Map<String, Object> info);

	int deleteOrderInfo(Map<String, Object> info);

	int getOrderInfoCount(Map<String, Object> info);
}
