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
import java.util.*;


@WebServlet(name = "ShowMemberInfoServlet",urlPatterns = "/dao.show_memberInfo")
public class ShowMemberInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        MemberInfoService memberInfoService = new MemberInfoServiceImpl();
        HttpSession session = request.getSession();
        Map<String, String> user_info = (Map<String, String>) session.getAttribute("user_info");
        Map<String,Object> info = new LinkedHashMap<>();

        int index, pageSize;
        if (request.getParameter("index") == null)
            index = 1;
        else {
            index = Integer.parseInt(request.getParameter("index"));
        }
        if(request.getParameter("pageSize") == null) {
            pageSize = 5;
        } else {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
        }

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            if(request.getParameter(parameterName).equals("")||parameterName.equals("pageSize")||parameterName.equals("index")) continue;
            info.put(parameterName, request.getParameter(parameterName));
        }
        List<Map<String ,String >> result = memberInfoService.queryMemberInfo(info,index,pageSize);
        int Num = memberInfoService.getMemberInfoCount(info);
        int total = Num%pageSize==0?Num/pageSize:Num/pageSize+1;
//        if (result ==null ||result.isEmpty()){
//            response.getWriter().println("fail");
//        }else{
//            request.setAttribute("infoList",result );
//            request.setAttribute("index",index);
//            request.setAttribute("count", Num);
//            request.setAttribute("total",total);
//            response.getWriter().println("ok");
//        }
        if (result ==null){
            response.getWriter().println("fail");
        }else{
            Map<String ,Object> data = new HashMap<>();
            data.put("infoList",result);
            data.put("total",total);// 总页号
            data.put("index",index);// 当前页号
            data.put("pageSize",pageSize);  //每页显示条数
            data.put("count",Num); //这是数量
            response.getWriter().println(JSON.toJSONString(util.CommonResult.success(data)));
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
