package servlet.orderInfo;

import com.alibaba.fastjson.JSON;
import service.OrderInfoService;
import service.impl.OrderInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "ToCheckInServlet",urlPatterns = "/dao.toCheckIn")
public class ToCheckInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Map<String, Object> user_info = (Map<String, Object>) session.getAttribute("user_info");
        String param = request.getParameter("order_id");
        OrderInfoService orderInfoService = new OrderInfoServiceImpl();
        Map<String, Object> info = new HashMap<>();
        info.put("order_id", param);
        Map<String, Object> other = new LinkedHashMap<>();

        other.put("breakfast", request.getParameter("breakfast"));
        other.put("wake", request.getParameter("wake"));

        Map<String, String> result = orderInfoService.toCheckIn(user_info,info,other);

        if (result == null) {
            response.getWriter().println("fail");
        } else {

//            response.getWriter().println(result.toString());
            response.getWriter().println(JSON.toJSONString(util.CommonResult.success(result)));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
