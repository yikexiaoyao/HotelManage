package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapUtil {
    public static List<Map<String,String>> getHashMapList(ResultSet rs) throws SQLException {

        List<Map<String,String>> dataTable = new ArrayList<Map<String,String>>();
        ResultSetMetaData rsmd = rs.getMetaData();
        while(rs.next()){
            Map<String,String> item = new HashMap<String,String>();
            for(int i=1; i<=rsmd.getColumnCount();i++){
                    putToHash(item, rsmd.getColumnName(i).toLowerCase(), rs.getString(i));
            }
            dataTable.add(item);
        }
        return dataTable;
    }

    public static Map<String,String> getHashMap(ResultSet rs) throws SQLException {

        Map<String,String> dataTable = new HashMap<>();
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println(rsmd.toString());
        if(rs.next()){
            for(int i=1; i<=rsmd.getColumnCount();i++){
                putToHash(dataTable, rsmd.getColumnName(i).toLowerCase(), rs.getString(i));
            }
        }
        return dataTable;
    }

    private static void putToHash(Map<String,String> item,String key,String value){
        if(value!= null){
            item.put(key, value);
        }
    }

    private static String getClobtoString(Clob clob) throws SQLException{
        return clob.getSubString(((long)1),((int)(clob.length())));
    }

}
