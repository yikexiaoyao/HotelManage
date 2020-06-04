package service;

import java.util.List;
import java.util.Map;

public interface CostInfoService {

    List<Map<String, String>> queryGoodsInfo(Map<String, Object> info, int index, int pageSize);

    List<Map<String, String>> queryCostInfo(Map<String, Object> info, int index, int pageSize);

    List<Map<String, String>> queryCostInfo(Map<String, Object> info);

    Float getTotalCost(Map<String, Object> info);

    int updateCostInfo(Map<String, Object> user, Map<String, Object> info, Map<String, Object> info2);

    int insertCostInfo(Map<String, Object> user, Map<String, Object> info);

    int deleteCostInfo(Map<String, Object> user, String info);

    int getCostInfoCount(Map<String, Object> info);

    int getGoodsInfoCount(Map<String, Object> info);

}
