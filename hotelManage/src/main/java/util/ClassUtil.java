package util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ClassUtil {

    final  static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
    public  static Object returnObjectClass(String key,String value){
        switch (key){
            case  "accommodation_fee":
            case "in_store_consumption":
            case "meals":
            case "telephone_fee":
            case "real_income":
            case "deposit":
            case "price":
            case "discounted_price":
            case "member_price":
            case "vip_price":return Float.parseFloat(value);

            case "bill_id":
            case "checkin_id":
            case "room_id":
            case "old_room_id":
            case "new_room_id":
            case "number":
            case "member_id":
            case "breakfast":
            case "wake":
            case "cost_id":
            case "goods_id":
            case "floor_id":
            case "type_id":
            case "log_id":
            case "integral":
            case "order_id":
            case "user_id":
            case "room_type_id": return  Integer.parseInt(value);

            case "arrivals_time":
            case "leave_time":
            case "time":
            case "check_in_time":
            case "scheduled_time":return returnDateClass(value);
            default:
                return value;
        }

    }

    private  static Timestamp returnDateClass(String value){
        try {
            Timestamp timestamp = new Timestamp(sdf.parse(value).getTime());
            return  timestamp;
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return  null;

    }
}
