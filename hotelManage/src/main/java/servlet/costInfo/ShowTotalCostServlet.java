package servlet.costInfo;

import com.alibaba.fastjson.JSON;
import service.CostInfoService;
import service.impl.CostInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "ShowTotalCostServlet",urlPatterns = "/dao.show_totalCoat")
public class ShowTotalCostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        CostInfoService costInfoService = new CostInfoServiceImpl();

        Map<String,Object> info = new LinkedHashMap<>();

        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            info.put(parameterName, request.getParameter(parameterName));
        }

        List<Map<String, String>> result = costInfoService.queryCostInfo(info);

        Float total = costInfoService.getTotalCost(info);


//        if (result ==null || result.isEmpty()){
//            response.getWriter().println("fail");
//
//        }else{
//            request.setAttribute("infoList",result );
//            request.setAttribute("total",total );
//            response.getWriter().println(result.toString());
//            response.getWriter().println(total);
//
//        }
        if (result ==null){
            response.getWriter().println("fail");
        }else{
            Map<String ,Object> data = new HashMap<>();
            data.put("infoList",result);
            data.put("total",total);// 总页号
            response.getWriter().println(JSON.toJSONString(util.CommonResult.success(data)));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
