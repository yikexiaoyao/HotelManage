package servlet.roomType;

import com.alibaba.fastjson.JSON;
import service.RoomTypeService;
import service.impl.RoomTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ToUpdateRoomTypeServlet",urlPatterns = "/dao.to_updateRoomType")
public class ToUpdateRoomTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String room_type_id = request.getParameter("room_type_id");

        RoomTypeService roomTypeService = new RoomTypeServiceImpl();
        Map<String ,Object> info = new HashMap<>();
        info.put("room_type_id",room_type_id);
         Map<String ,String > roomType = roomTypeService.queryRoomType(info).get(0);
//        if (roomType ==null ||roomType.isEmpty()){
        if (roomType ==null){
            response.getWriter().println("fail");
        }else{
            request.setAttribute("info",roomType );
//            response.getWriter().println("ok");
            response.getWriter().println(JSON.toJSONString(util.CommonResult.success()));
        }





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
