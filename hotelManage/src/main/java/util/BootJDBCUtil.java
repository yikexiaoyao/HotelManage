package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BootJDBCUtil {
	public static int getCount(String table, Map<String, Object> info) {
		Connection conn = DBUtil.getConnection();
		String sql;
		if (info == null || info.isEmpty()) {
			sql = "select count(1) from " + table;
		} else {
			sql = "select count(1) from " + table + " where "
					+ info.keySet().toString().replaceAll(",", " = ? and").substring(1).replaceAll("]", " = ?");
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			if (!(info == null || info.isEmpty())) {
				Object[] objects = info.values().toArray();
				for (int i = 0; i < info.size(); i++) {
					ps.setObject(i + 1, objects[i]);
				}
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

	public static int getCount(String sql){
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static int bootUpdateInfo(String table, Map<String, Object> info, Map<String, Object> info2) {
		if (info == null || info.isEmpty() || info2 == null || info2.isEmpty())
			return 0;
		Connection conn = DBUtil.getConnection();
		StringBuilder stringBuilder = new StringBuilder("update  " + table + " set "
				+ info.keySet().toString().substring(1).replaceAll(",", "=?,").replaceAll("]", "=? "));
		stringBuilder.append(
				"where " + info2.keySet().toString().substring(1).replaceAll(",", "=? and").replaceAll("]", "=?"));
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(stringBuilder.toString());
			Object[] objects = info.values().toArray();
			Object[] objects1 = info2.values().toArray();
			for (int i = 0; i < info.size() + info2.size(); i++) {
				if (i < info.size())
					ps.setObject(i + 1, objects[i]);
				else
					ps.setObject(i + 1, objects1[i - info.size()]);
			}
			System.out.println(ps.toString());
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public static int bootDelInfo(String table, Map<String, Object> info) {
		if (info == null || info.isEmpty())
			return 0;
		Connection conn = DBUtil.getConnection();
		String sql = "delete from " + table + " where "
				+ info.keySet().toString().replaceAll(",", " = ? and").substring(1).replaceAll("]", " = ?");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			Object[] objects = info.values().toArray();
			for (int i = 0; i < info.size(); i++) {
				ps.setObject(i + 1, objects[i]);
			}
			System.out.println(ps.toString());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}


	public static List<Map<String, String>> bootQueryInfo(String table, Map<String, Object> info) {

		Connection conn = DBUtil.getConnection();
		String sql;
		if (info == null || info.isEmpty()) {
			sql = "select * from " + table;
		} else {
			sql = "select * from " + table + " where "
					+ info.keySet().toString().replaceAll(",", " = ? and").substring(1).replaceAll("]", " = ?");
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			if (!(info == null || info.isEmpty())) {
				Object[] objects = info.values().toArray();
				for (int i = 0; i < info.size(); i++) {
					ps.setObject(i + 1, objects[i]);
				}
			}
			System.out.println(ps.toString());
			rs = ps.executeQuery();
			return HashMapUtil.getHashMapList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<Map<String, String>> bootQueryInfoLink(String sql,String table, Map<String, Object> info){
		Connection conn = DBUtil.getConnection();
		if (!(info == null || info.isEmpty())) {
			sql += " and " +table+"." + info.keySet().toString().replaceAll(",", " = ? and "+table+".")
					.substring(1).replaceAll("]", " = ?" );
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			if (!(info == null || info.isEmpty())) {
				Object[] objects = info.values().toArray();
				for (int i = 0; i < info.size(); i++) {
					ps.setObject(i + 1, objects[i]);
				}
			}
			System.out.println(ps.toString());
			rs = ps.executeQuery();
			return HashMapUtil.getHashMapList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<Map<String, String>> bootQueryInfoLink(String sql,String table, Map<String, Object> info, int index,
															  int pageSize){
		Connection conn = DBUtil.getConnection();
		if (info == null || info.isEmpty()) {
			sql += " limit " + (index - 1) * pageSize + "," + pageSize;
		} else {
			sql += " and " +table+"." + info.keySet().toString().replaceAll(",", " = ? and "+table+".")
					.substring(1).replaceAll("]", " = ?" + " limit " + (index - 1) * pageSize + "," + pageSize);
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			if (!(info == null || info.isEmpty())) {
				Object[] objects = info.values().toArray();
				for (int i = 0; i < info.size(); i++) {
					ps.setObject(i + 1, objects[i]);
				}
			}
			System.out.println(ps.toString());
			rs = ps.executeQuery();
			return HashMapUtil.getHashMapList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<Map<String, String>> bootQueryInfo(String table, Map<String, Object> info, int index,
														  int pageSize) {
		Connection conn = DBUtil.getConnection();
		String sql;
		if (info == null || info.isEmpty()) {
			sql = "select * from " + table + " limit " + (index - 1) * pageSize + "," + pageSize;
		} else {
			sql = "select * from " + table + " where " + info.keySet().toString().replaceAll(",", " = ? and")
					.substring(1).replaceAll("]", " = ?" + " limit " + (index - 1) * pageSize + "," + pageSize);
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			if (!(info == null || info.isEmpty())) {
				Object[] objects = info.values().toArray();
				for (int i = 0; i < info.size(); i++) {
					ps.setObject(i + 1, objects[i]);
				}
			}
			System.out.println(ps.toString());
			rs = ps.executeQuery();
			return HashMapUtil.getHashMapList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static List<Map<String, String>> bootQueryInfoByLike(String table, Map<String, Object> info) {
		if (info == null || info.isEmpty())
			return null;
		Connection conn = DBUtil.getConnection();
		String sql = "select * from " + table + " where "
				+ info.keySet().toString().replaceAll(",", " like ? and").substring(1).replaceAll("]", " like ?");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			if (!(info == null || info.isEmpty())) {
				Object[] objects = info.values().toArray();
				for (int i = 0; i < info.size(); i++) {
					System.out.println(i + 1);
					ps.setObject(i + 1, "%" + objects[i] + "%");
				}
			}
			System.out.println(ps.toString());
			rs = ps.executeQuery();
			return HashMapUtil.getHashMapList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public static int bootInsertInfo(String table, Map<String, Object> info) {
		if (info == null || info.isEmpty())
			return 0;
		Connection conn = DBUtil.getConnection();
		StringBuilder stringBuilder = new StringBuilder("insert into " + table + " ("
				+ info.keySet().toString().substring(1).replaceAll("]", ")") + " VALUES (");
		for (int i = 0; i < info.size() - 1; i++) {
			stringBuilder.append("?,");
		}
		stringBuilder.append("?)");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(stringBuilder.toString());
			Object[] objects = info.values().toArray();
			for (int i = 0; i < info.size(); i++) {
				ps.setObject(i + 1, objects[i]);
			}
			System.out.println(ps.toString());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
