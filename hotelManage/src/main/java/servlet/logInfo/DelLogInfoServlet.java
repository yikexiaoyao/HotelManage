package servlet.logInfo;

import com.alibaba.fastjson.JSON;
import service.LogInfoService;
import service.impl.LogInfoServiceImpl;

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

@WebServlet(name = "DelLogInfoServlet",urlPatterns = "/dao.del_logInfo")
public class DelLogInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        Map<String, Object> user_info = (Map<String, Object>) session.getAttribute("user_info");

        LogInfoService logInfoService = new LogInfoServiceImpl();
        Map<String,Object> info = new LinkedHashMap<>();

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            if(request.getParameter(parameterName).equals("")||parameterName.equals("pageSize")||parameterName.equals("index")) continue;
            info.put(parameterName, request.getParameter(parameterName));        }

        if (logInfoService.deleteLogInfo(user_info,info)>0){
            response.getWriter().println(JSON.toJSONString(util.CommonResult.success()));
        } else {
            response.getWriter().println(JSON.toJSONString(util.CommonResult.failed()));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
