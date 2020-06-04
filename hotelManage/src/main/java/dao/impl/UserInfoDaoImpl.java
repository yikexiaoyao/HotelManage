package dao.impl;

import dao.UserInfoDao;
import util.BootJDBCUtil;

import java.util.List;
import java.util.Map;

public class UserInfoDaoImpl implements UserInfoDao {
    @Override
    public List<Map<String, String>> queryUserInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfo("user_info",info);
    }

    @Override
    public List<Map<String, String>> queryUserInfo(Map<String, Object> info, int index, int pageSize) {
        return BootJDBCUtil.bootQueryInfo("user_info",info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryUserInfoByLike(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfoByLike("user_info",info);
    }

    @Override
    public int updateUserInfo(Map<String, Object> info, Map<String, Object> info2) {
        return BootJDBCUtil.bootUpdateInfo("user_info",info,info2);
    }

    @Override
    public int insertUserInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootInsertInfo("user_info",info);
    }

    @Override
    public int deleteUserInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootDelInfo("user_info",info);
    }

    @Override
    public int getUserInfoCount(Map<String, Object> info) {
        return BootJDBCUtil.getCount("user_info",info);
    }
}
