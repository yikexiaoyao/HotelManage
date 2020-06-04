import dao.GoodsInfoDao;
import dao.impl.GoodsInfoDaoImpl;
import service.BillInfoService;
import service.GoodsInfoService;
import service.impl.BillInfoServiceImpl;
import service.impl.GoodsInfoServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class TestJDBC {
    public static void main(String[] args) {
        Map<String ,Object> info  = new HashMap<>();
        GoodsInfoDao dao = new GoodsInfoDaoImpl();
        BillInfoService billInfoService =new BillInfoServiceImpl();
        info.put("checkin_id",1);
//        info.put("arrivals_time",new Date());


        System.out.println();
//        System.out.println(dao.queryGoodsInfo(info,1,5));
        System.out.println(billInfoService.showCostInfo(info));
    }
}
