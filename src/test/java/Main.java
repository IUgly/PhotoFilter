import com.alibaba.fastjson.JSONObject;
import org.main.redrock.utils.FileReader;
import org.main.redrock.utils.HttpUtil;

import java.io.File;

public class Main {
    public static void main(String[] args) {
//        String filePath = "C:/Users/ugly/Desktop/PhotoFilter/out/artifacts/PhotoFilter_war_exploded/picture/20180526213410 93b12b8b-2bc5-495d-81b8-403244e4602b 二维码.jpg";
//        String url = "https://web.everphoto.cn/api/cv/shinkai/web";
//
//        JSONObject json = HttpUtil.getImgJson(url, filePath);
//        System.out.println(json);
//        JSONObject data = (JSONObject) json.get("data");
//        String imgurl = (String) data.get("url");
//        System.out.println(data);
//        System.out.println(imgurl);
        File file = new File("C:\\Users\\ugly\\Pictures\\二维码.jpg");
        String fileName = file.getName();
        System.out.println(fileName);
    }
}
