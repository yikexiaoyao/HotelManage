package servlet.billInfo;

import com.alibaba.fastjson.JSON;
import service.BillInfoService;
import service.impl.BillInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "AddBillInfoServlet",urlPatterns = "/dao.add_billInfo")
public class AddBillInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        Map<String, Object> user_info = (Map<String, Object>) session.getAttribute("user_info");

        BillInfoService billInfoService = new BillInfoServiceImpl();

        Map<String,Object> info = new LinkedHashMap<>();

        Float income = Float.parseFloat(request.getParameter("income"));
        Float real_income = Float.parseFloat(request.getParameter("real_income"));

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            if(request.getParameter(parameterName).equals("")) continue;
            if (parameterName.equals("in_store_consumption_detail"))continue;

            info.put(parameterName, request.getParameter(parameterName));
        }

        info.put("return_money",(income-real_income));
        if (0 < billInfoService.insertBillInfo(user_info, info)) {
//            response.getWriter().println("ok");
            response.getWriter().println(JSON.toJSONString(util.CommonResult.success()));
        } else {
            response.getWriter().println("fail");
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
