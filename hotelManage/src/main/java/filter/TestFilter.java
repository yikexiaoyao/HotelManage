package filter;

import service.FloorInfoService;
import service.GoodsInfoService;
import service.RoomTypeService;
import service.impl.FloorInfoServiceImpl;
import service.impl.GoodsInfoServiceImpl;
import service.impl.RoomTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebFilter(filterName = "TestFilter",urlPatterns = "/*",
        initParams = {@WebInitParam(name = "charset", value = "utf-8")/*这里可以放一些初始化的参数*/
})
public class TestFilter implements Filter {
    private String filterName;
    private String charset;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(charset);
        resp.setCharacterEncoding(charset);


        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;

        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        // 响应类型允许的方法
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
        // 响应头设置
        httpResponse.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin,Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");

        if (httpRequest.getMethod().equals("OPTIONS")) {
            System.out.println("Filter 过滤器 执行 了 OPTIONS");
            httpResponse.setStatus(200);
            //.setStatus(HttpStatus.NO_CONTENT);
            return;
        }

        Map<String,Object> user = new LinkedHashMap<>();
        user.put("user_id",1);
        user.put("username","admin");
        user.put("authority","1");
        FloorInfoService floorInfoService = new FloorInfoServiceImpl();
        GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
        RoomTypeService roomTypeService = new RoomTypeServiceImpl();
        HttpSession session = httpRequest.getSession();

        session.setAttribute("user_info",user);
        session.setAttribute("goodsType",goodsInfoService.queryGoodsInfo(null));
        session.setAttribute("floorInfo",floorInfoService.queryFloorInfo(null));
        session.setAttribute("roomType",roomTypeService.queryRoomType(null));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println(123123);
        filterName = config.getFilterName();
        charset = config.getInitParameter("charset");
    }

}
