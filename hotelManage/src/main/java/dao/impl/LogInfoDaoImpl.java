package dao.impl;

import util.BootJDBCUtil;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class LogInfoDaoImpl implements dao.LogInfoDao {
    @Override
    public List<Map<String, String>> queryLogInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfo("log_info",info);
    }

    @Override
    public List<Map<String, String>> queryLogInfo(Map<String, Object> info, int index, int pageSize) {
        if(info.containsKey("time")){
            String temp1  =  (String)info.get("time");
            String sql = "select * from log_info where time BETWEEN "+temp1.split(",")[0]+" and "+temp1.split(",")[1];
            info.remove("time");
            return BootJDBCUtil.bootQueryInfoLink(sql,"log_info",info,index,pageSize);
        }

        return BootJDBCUtil.bootQueryInfo("log_info",info,index,pageSize);
    }

    @Override
    public List<Map<String, String>> queryLogInfoByLike(Map<String, Object> info) {
        return BootJDBCUtil.bootQueryInfoByLike("log_info",info);
    }

    @Override
    public int updateLogInfo(Map<String, Object> info, Map<String, Object> info2) {
        return BootJDBCUtil.bootUpdateInfo("log_info",info,info2);
    }

    @Override
    public int insertLogInfo(Map<String, Object> info) {
        return BootJDBCUtil.bootInsertInfo("log_info",info);
    }

    @Override
    public int deleteLogInfo(Map<String, Object> info) {
        if (info.containsKey("time")){
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String temp1  =  (String)info.get("time");
            String sql = "delete from log_info where time BETWEEN "+temp1.split(",")[0]+" and "+temp1.split(",")[1];
            int result = 0;
            try {
                ps =conn.prepareStatement(sql);
                result = ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    DBUtil.close(conn,ps,rs);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return result;
        }
        return BootJDBCUtil.bootDelInfo("log_info",info);
    }

    @Override
    public int getLogInfoCount(Map<String, Object> info) {
        if(info.containsKey("time")){
            String temp1  =  (String)info.get("time");
            String sql = "select count(1) from log_info where time BETWEEN "+temp1.split(",")[0]+" and "+temp1.split(",")[1];
            return BootJDBCUtil.getCount(sql);
        }
        return BootJDBCUtil.getCount("log_info",info);
    }
}
