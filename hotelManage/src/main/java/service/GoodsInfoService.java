package service;

import java.util.List;
import java.util.Map;

public interface GoodsInfoService {
    List<Map<String, String>> queryGoodsInfo(Map<String, Object> info, int index, int pageSize);
    List<Map<String, String>> queryGoodsInfo(Map<String, Object> info);

    List<Map<String, String>> queryGoodsInfoByGoodType(String name, int index, int pageSize);

    int updateGoodsInfo(Map<String, Object> user,Map<String, Object> info, Map<String, Object> info2);

    int insertGoodsInfo(Map<String, Object> user,Map<String, Object> info);

    int deleteGoodsInfo(Map<String, Object> user,String  info);

    int getGoodsInfoCount(Map<String, Object> info);
}
