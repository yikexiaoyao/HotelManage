package servlet.userInfo;

import com.alibaba.fastjson.JSON;
import service.UserInfoService;
import service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ToUpdateUserInfoServlet",urlPatterns = "/dao.to_userInfo")
public class ToUpdateUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String user_id = request.getParameter("user_id");

        UserInfoService userInfoService = new UserInfoServiceImpl();
        Map<String ,Object> info = new HashMap<>();
        info.put("user_id",user_id);
        Map<String ,String > result = userInfoService.queryUserInfo(info,1,1).get(0);
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
