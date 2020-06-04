package servlet.logInfo;

import com.alibaba.fastjson.JSON;
import service.LogInfoService;
import service.impl.LogInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "ShowLogInfoServlet",urlPatterns = "/dao.show_LogInfo")
public class ShowLogInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        LogInfoService logInfoService =  new LogInfoServiceImpl();
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
            info.put(parameterName, request.getParameter(parameterName));        }

        List<Map<String ,String >> logInfoList = logInfoService.queryLogInfo(info,index,pageSize);

        int Num = logInfoService.getLogInfoCount(info);
        int total = Num%pageSize==0?Num/pageSize:Num/pageSize+1;


        if (logInfoList ==null ){
            response.getWriter().println(JSON.toJSONString(util.CommonResult.failed()));

        }else{
            Map<String ,Object> data = new HashMap<>();
            data.put("infoList",logInfoList);
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
