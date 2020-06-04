package servlet.memberInfo;

import com.alibaba.fastjson.JSON;
import service.MemberInfoService;
import service.impl.MemberInfoServiceImpl;

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

@WebServlet(name = "UpdateMemberInfoServlet",urlPatterns = "/dao.update_memberInfo")
public class UpdateMemberInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        MemberInfoService memberInfoService = new MemberInfoServiceImpl();

        HttpSession session = request.getSession();
        Map<String, Object> user_info = (Map<String, Object>) session.getAttribute("user_info");

        Map<String,Object> info = new LinkedHashMap<>();
        Map<String,Object> info2 = new LinkedHashMap<>();
        info2.put("member_id",request.getParameter("member_id"));

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            if (parameterName.equals("member_id")) continue;
            if(request.getParameter(parameterName).equals("")) continue;
            info.put(parameterName, request.getParameter(parameterName));
        }
        if (memberInfoService.updateMemberInfo(user_info,info,info2)>0){
//            response.getWriter().println("ok");
            response.getWriter().println(JSON.toJSONString(util.CommonResult.success()));
        }else{
            response.getWriter().println("fail");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
