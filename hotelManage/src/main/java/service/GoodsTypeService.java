package service;

import java.util.List;
import java.util.Map;

public interface GoodsTypeService {
    List<Map<String, String>> queryGoodsType(Map<String, Object> info, int index, int pageSize);


    int updateGoodsType(Map<String, Object> user,Map<String, Object> info, Map<String, Object> info2);

    int insertGoodsType(Map<String, Object> user,Map<String, Object> info);

    int deleteGoodsType(Map<String, Object> user,String info);

    int getGoodsTypeCount(Map<String, Object> info);
}
