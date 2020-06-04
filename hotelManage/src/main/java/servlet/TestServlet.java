package servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import util.BootJDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@WebServlet(name = "TestServlet",urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符集
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        // 获取jsonStr
//        StringBuffer jsonStr = new StringBuffer();
//        String line = null;
//        try {
//            BufferedReader reader = request.getReader();
//            while ((line = reader.readLine()) != null) {
//                jsonStr.append(line);
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        System.out.println(jsonStr.toString());

        BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null)
            responseStrBuilder.append(inputStr);


        System.out.println(responseStrBuilder.toString());
//        System.out.println(responseStrBuilder.toString());
        JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
        Map<String, Object> user =  jsonObject.getInnerMap();
        System.out.println(user.toString());
        Map<String,Object> info  =  new LinkedHashMap<>((Map<String, Object>) user.get("username"));

        System.out.println(info.toString());
//        LinkedHashMap<String, Object> user = (LinkedHashMap<String, Object>) jsonObject.getString("user");

//        System.out.println(jsonObject.getString("user"));
//        System.out.println(list.toString());

        System.out.println(12312234);
        out.write(JSON.toJSONString(BootJDBCUtil.bootQueryInfo("goods_info",null)));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
