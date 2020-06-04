package dao.impl;

import util.BootJDBCUtil;

import java.util.List;
import java.util.Map;

public class MemberInfoDaoImpl implements dao.MemberInfoDao {
    @Override
    public List<Map<String, String>> queryMemberInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfo("member_info",info);
    }

    @Override
    public List<Map<String, String>> queryMemberInfo(Map<String, Object> info, int index, int pageSize) {
        return BootJDBCUtil.bootQueryInfo("member_info",info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryMemberInfoByLike(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfoByLike("member_info",info);
    }

    @Override
    public int updateMemberInfo(Map<String, Object> info, Map<String, Object> info2) {
        return BootJDBCUtil.bootUpdateInfo("member_info",info,info2);
    }

    @Override
    public int insertMemberInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootInsertInfo("member_info",info);
    }

    @Override
    public int deleteMemberInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootDelInfo("member_info",info);
    }

    @Override
    public int getMemberInfoCount(Map<String, Object> info) {
        return BootJDBCUtil.getCount("member_info",info);
    }
}
