import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import service.RoomInfoService;
import service.impl.RoomInfoServiceImpl;

import java.util.HashMap;
import java.util.Map;

/****
 ** Log4J Demo
 **/
@Slf4j
public class Log4jLog {


    public static void main(String[] args) {
        System.out.println(123123123);
        log.error("撒旦发射点发");

    }
    @Test
    public void test() throws InterruptedException {
        System.out.println(String.format("%s,%s",12,123));
        RoomInfoService service = new RoomInfoServiceImpl();
        Map<String,Object> info = new HashMap<>();
        Map<String,Object> info2 = new HashMap<>();
        info.put("discounted_price",new float[]{123,123123});
        info.put("vip_price",1.00f);

        System.out.println(service.queryRoomInfo(info,1,5));
    }
}