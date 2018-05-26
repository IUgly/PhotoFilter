package org.main.redrock.controller;
import com.alibaba.fastjson.JSONObject;
import org.main.redrock.utils.FileUtils;
import org.main.redrock.utils.HttpUtil;
import org.main.redrock.utils.StreamUtil;
import sun.net.www.http.HttpClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/index")
public class InitialServlet extends HttpServlet{
    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        try{
            List<String> filePath = FileUtils.upload
                    (req, "picture/", ".jpg");
            File file = new File(filePath.get(0));
            String fileName = file.getName();

            req.setAttribute("Before",
                    "http://www.kuangjunlin.xin:8080/PhotoFilter/picture/"+fileName);
            JSONObject json = HttpUtil.getImgJson("https://web.everphoto.cn/api/cv/shinkai/web", filePath.get(0));
            JSONObject data = (JSONObject) json.get("data");
            String url = data.getString("url");
            req.setAttribute("After", url);

            if (filePath==null&&filePath.isEmpty()&&url==null&&url.isEmpty()){
                StreamUtil.writeStream(resp.getOutputStream(), String.valueOf("文件格式错误"));
            }else {
                req.getRequestDispatcher("filter.jsp").forward(req, resp);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            req.getRequestDispatcher("filter.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            doPost(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
