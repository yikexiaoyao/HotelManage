package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BillInfoDao;
import org.omg.CORBA.OBJ_ADAPTER;
import util.BootJDBCUtil;
import util.DBUtil;
import util.HashMapUtil;

public class BillInfoDaoImpl implements BillInfoDao {

	@Override
	public Map<String, Object> queryTotalCostInfo(Map<String, Object> info) {
		// TODO Auto-generated method stub
		String sql = "SELECT checkin_info.checkin_id,room_id,checkin_price,deposit,TO_DAYS(checkin_info.leave_time)-TO_DAYS(checkin_info.arrivals_time) as 'days',(TO_DAYS(checkin_info.leave_time)-TO_DAYS(checkin_info.arrivals_time))*checkin_price as accommodation_fee," +
				"SUM(cost_info.number*cost_price) as in_store_consumption, SUM(cost_info.number*cost_price)+(TO_DAYS(checkin_info.leave_time)-TO_DAYS(checkin_info.arrivals_time))*checkin_price AS real_income" +
				" FROM checkin_info,cost_info,goods_info,goods_type" +
				" where checkin_info.checkin_id = cost_info.checkin_id and cost_info.goods_id = goods_info.goods_id and goods_type.type_id = goods_info.type_id";

		Map<String, String> resultTemp = BootJDBCUtil.bootQueryInfoLink(sql, "checkin_info", info, 1, 1).get(0);
		if (resultTemp == null || resultTemp.isEmpty()) {
			sql = "SELECT checkin_info.checkin_id,room_id,checkin_price,deposit,TO_DAYS(checkin_info.leave_time)-TO_DAYS(checkin_info.arrivals_time) as 'days',(TO_DAYS(checkin_info.leave_time)-TO_DAYS(checkin_info.arrivals_time))*checkin_price as accommodation_fee,SUM(cost_info.number*cost_price) as in_store_consumption, SUM(cost_info.number*cost_price)+(TO_DAYS(checkin_info.leave_time)-TO_DAYS(checkin_info.arrivals_time))*checkin_price AS real_income FROM checkin_info,cost_info,goods_info,goods_type where checkin_info.checkin_id = ?";
			Map<String, Object> result = new HashMap<>();
			result.putAll(resultTemp);
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement(sql);
				ps.setObject(1, info.get("checkin_id"));
				System.out.println(ps.toString());
				Map<String, String> temp1 = new HashMap<>();
				rs = ps.executeQuery();
				resultTemp= HashMapUtil.getHashMapList(rs).get(0);
				result.putAll(resultTemp);
				result.put("in_store_consumption", 0);
				result.put("real_income", resultTemp.get("accommodation_fee"));
				return result;
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				try {
					DBUtil.close(conn, ps, rs);
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
			return null;

		} else {
			String sql2 = "SELECT goods_type,SUM(number*discount) as price FROM cost_info,goods_info,goods_type" +
					" where cost_info.goods_id = goods_info.goods_id and goods_type.type_id = goods_info.type_id and checkin_id=?" +
					" GROUP BY goods_type.type_id";
			Map<String, Object> result = new HashMap<>();
			result.putAll(resultTemp);
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement(sql2);
				ps.setObject(1, info.get("checkin_id"));
				System.out.println(ps.toString());
				Map<String, String> temp1 = new HashMap<>();
				rs = ps.executeQuery();
				while (rs.next()) {
					temp1.put(rs.getString(1), rs.getString(2));
				}
				result.put("in_store_consumption_detail", temp1);
				return result;
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			} finally {
				try {
					DBUtil.close(conn, ps, rs);
				} catch (SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}
		return null;

	}


	@Override
	public List<Map<String, String>> queryTodayBillInfoReportForm(Map<String, Object> info, int index, int pageSize) {
		String today = (String) info.get("todayDate");
		String sql;
		if (today != null && today.length() > 0) {
			sql = "SELECT a.*,b.type,c.checkiner,c.member_id,c.leave_time FROM  bill_info a,room_type b,checkin_info c WHERE DATE_FORMAT(c.leave_time,\"%Y-%m-%d\") = '" + today + "'";
			info.clear();
		} else {
			sql = "SELECT a.*,b.type,c.checkiner,c.member_id,c.leave_time FROM  bill_info a,room_type b,checkin_info c";
		}

		return BootJDBCUtil.bootQueryInfoLink(sql, "a", info);
	}

	@Override
	public List<Map<String, String>> queryBillInfo(Map<String, Object> info, int index, int pageSize) {
		// TODO Auto-generated method stub
		return BootJDBCUtil.bootQueryInfo("bill_info", info, index, pageSize);
	}

	@Override
	public List<Map<String, String>> queryBillInfoByLike(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return BootJDBCUtil.bootQueryInfoByLike("bill_info", info);
	}

	@Override
	public int updateBillInfo(Map<String, Object> info, Map<String, Object> info2) {
		// TODO Auto-generated method stub
		return BootJDBCUtil.bootUpdateInfo("bill_info", info, info2);
	}

	@Override
	public int insertBillInfo(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return BootJDBCUtil.bootInsertInfo("bill_info", info);
	}

	@Override
	public int deleteBillInfo(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return BootJDBCUtil.bootDelInfo("bill_info", info);
	}

	@Override
	public int getBillInfoCount(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return BootJDBCUtil.getCount("bill_info", info);
	}

}
