package service;

import java.util.List;
import java.util.Map;

public interface BillInfoService {
    List<Map<String, String>> queryCheckinInfo(Map<String, Object> info, int index, int pageSize);

    Map<String,Object>  showCostInfo(Map<String,Object> info);
    List<Map<String, String>> queryTodayBillInfoReportForm(Map<String, Object> info, int index, int pageSize);


    int insertBillInfo(Map<String,Object> user,Map<String ,Object> info);


    int getCheckinInfoCount(Map<String, Object> info);
    int getBillInfoCount(Map<String, Object> info);

    List<Map<String, String>> queryBillInfo(Map<String, Object> info, int index, int pageSize);


}
