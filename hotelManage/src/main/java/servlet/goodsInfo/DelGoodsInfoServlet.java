package servlet.goodsInfo;

import com.alibaba.fastjson.JSON;
import service.GoodsInfoService;
import service.RoomTypeService;
import service.impl.GoodsInfoServiceImpl;
import service.impl.RoomTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "DelGoodsInfoServlet",urlPatterns = "/dao.del_goodsInfo")
public class DelGoodsInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        Map<String, Object> user_info = (Map<String, Object>) session.getAttribute("user_info");

        GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();

        String info =request.getParameter("goods_id");
        if (goodsInfoService.deleteGoodsInfo(user_info,info)>0){
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
