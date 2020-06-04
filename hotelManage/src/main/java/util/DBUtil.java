package util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    static final String configPath = DBUtil.class.getResource("/").getPath()+"/config/DBConfig.properties"; //配置文件地址
    static String driver = null; //数据库驱动名
    static String url = null; // 数据库连接地址
    static String username = null; // 数据库用户名
    static String password = null; // 数据库密码

    static {
        LoadConfig();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static final void LoadConfig() {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(new File(configPath)));
            Properties properties = new Properties();
            properties.load(in);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

        } catch (FileNotFoundException e) {
            System.out.println("properties文件路径书写有误");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static final Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public static final void close(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

    public static final void close(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            ps.close();
        }
    }

    public static final void close(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
