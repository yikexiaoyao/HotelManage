package servlet.roomInfo;

import com.alibaba.fastjson.JSON;
import service.RoomInfoService;
import service.impl.RoomInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ToUpdateRoomInfoServlet",urlPatterns = "/dao.to_roomInfo")
public class ToUpdateRoomInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String room_id = request.getParameter("room_id");
        RoomInfoService roomInfoService = new RoomInfoServiceImpl();
        Map<String ,Object> info = new HashMap<>();
        info.put("room_id",room_id);
        Map<String ,String > result = roomInfoService.queryRoomInfo(info,1,1).get(0);
        if (result ==null){
            response.getWriter().println("fail");
        }else{
            request.setAttribute("info",result );
//            response.getWriter().println("ok");
            response.getWriter().println(JSON.toJSONString(util.CommonResult.success()));
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
