package servlet.goodsInfo;

import com.alibaba.fastjson.JSON;
import service.GoodsInfoService;
import service.impl.GoodsInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ToUpdateGoodsInfoServlet",urlPatterns = "/dao.to_goodsInfo")
public class ToUpdateGoodsInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String goods_id = request.getParameter("goods_id");

        GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
        Map<String ,Object> info = new HashMap<>();
        info.put("goods_id",goods_id);
        Map<String ,String > result = goodsInfoService.queryGoodsInfo(info,1,1).get(0);

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
