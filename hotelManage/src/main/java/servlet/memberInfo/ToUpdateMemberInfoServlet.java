package servlet.memberInfo;

import com.alibaba.fastjson.JSON;
import service.MemberInfoService;
import service.impl.MemberInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ToUpdateMemberInfoServlet",urlPatterns = "/dao.to_memberInfo")
public class ToUpdateMemberInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String member_id = request.getParameter("member_id");
        MemberInfoService memberInfoService = new MemberInfoServiceImpl();
        Map<String ,Object> info = new HashMap<>();
        info.put("member_id",member_id);
        Map<String ,String > result = memberInfoService.queryMemberInfo(info,1,1).get(0);
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
