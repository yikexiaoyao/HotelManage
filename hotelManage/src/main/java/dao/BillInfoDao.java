package dao;

import java.util.List;
import java.util.Map;

public interface BillInfoDao {
	Map<String, Object> queryTotalCostInfo(Map<String, Object> info);

	List<Map<String, String>> queryBillInfo(Map<String, Object> info, int index, int pageSize);
	List<Map<String, String>> queryTodayBillInfoReportForm(Map<String, Object> info, int index, int pageSize);
	List<Map<String,String>> queryBillInfoByLike(Map<String, Object> info);


	int updateBillInfo(Map<String, Object> info, Map<String, Object> info2);

	int insertBillInfo(Map<String, Object> info);

	int deleteBillInfo(Map<String, Object> info);

	int getBillInfoCount(Map<String, Object> info);



}
