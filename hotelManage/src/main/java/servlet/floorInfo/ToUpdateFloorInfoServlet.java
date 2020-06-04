package servlet.floorInfo;

import com.alibaba.fastjson.JSON;
import service.FloorInfoService;
import service.GoodsTypeService;
import service.impl.FloorInfoServiceImpl;
import service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ToUpdateFloorInfoServlet",urlPatterns = "/dao.to_updateFloorInfo")
public class ToUpdateFloorInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String floor_id = request.getParameter("floor_id");

        FloorInfoService floorInfoService = new FloorInfoServiceImpl();
        Map<String ,Object> info = new HashMap<>();
        info.put("floor_id",floor_id);
        Map<String ,String > result = floorInfoService.queryFloorInfo(info,1,1).get(0);
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
