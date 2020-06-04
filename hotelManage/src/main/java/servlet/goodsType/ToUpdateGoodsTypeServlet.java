package servlet.goodsType;

import com.alibaba.fastjson.JSON;
import service.GoodsTypeService;
import service.RoomTypeService;
import service.impl.GoodsTypeServiceImpl;
import service.impl.RoomTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ToUpdateGoodsTypeServlet",urlPatterns = "/dao.to_updateGoodsType")
public class ToUpdateGoodsTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type_id = request.getParameter("type_id");

        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        Map<String ,Object> info = new HashMap<>();
        info.put("type_id",type_id);
        Map<String ,String > result = goodsTypeService.queryGoodsType(info,1,1).get(0);
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
