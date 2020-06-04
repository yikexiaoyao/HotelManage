package service;

import java.util.List;
import java.util.Map;

public interface LogInfoService {
    List<Map<String, String>> queryLogInfo(Map<String, Object> info,int index, int pageSize);

    int deleteLogInfo(Map<String, Object> user,Map<String, Object> info);

    int getLogInfoCount(Map<String, Object> info);
}
