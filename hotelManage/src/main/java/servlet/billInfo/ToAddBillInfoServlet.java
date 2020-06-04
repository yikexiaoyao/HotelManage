package servlet.billInfo;

import com.alibaba.fastjson.JSON;
import service.BillInfoService;
import service.impl.BillInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ToAddBillInfoServlet",urlPatterns = "/dao.toAdd_billInfo")
public class ToAddBillInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String checkin_id = request.getParameter("checkin_id");

        BillInfoService BillInfoService = new BillInfoServiceImpl();
        Map<String ,Object> info = new HashMap<>();
        info.put("checkin_id",checkin_id);
        Map<String ,Object> result = BillInfoService.showCostInfo(info);
        if (result ==null){
            response.getWriter().println("fail");
        }else{
//            request.setAttribute("info",result );
//            response.getWriter().println(result);
            response.getWriter().println(JSON.toJSONString(util.CommonResult.success()));
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
