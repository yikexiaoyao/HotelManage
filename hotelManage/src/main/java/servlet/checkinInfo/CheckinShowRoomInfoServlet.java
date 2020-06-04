package servlet.checkinInfo;

import com.alibaba.fastjson.JSON;
import service.CheckinInfoService;
import service.impl.CheckinInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "CheckinShowRoomInfoServlet",urlPatterns = "/dao.show_roomInfoCheckin")
public class CheckinShowRoomInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        CheckinInfoService checkinInfoService = new CheckinInfoServiceImpl();
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
        List<Map<String ,String >> result = checkinInfoService.queryRoomInfo(info,index,pageSize);
        int Num = checkinInfoService.getRoomInfoCount(info);
        int total = Num%pageSize==0?Num/pageSize:Num/pageSize+1;

        if (result ==null){
            response.getWriter().println(JSON.toJSONString(util.CommonResult.failed()));
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
