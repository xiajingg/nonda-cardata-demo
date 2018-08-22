package nonda.cardata.controller;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class UrlController {

    /**
     * 获取图片

     */
    @Transactional(propagation= Propagation.REQUIRED)
    @Test
    public void GetImage(){
        try {
            //创建浏览器, 并设置一些参数
            WebClient webClient = new WebClient();
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setUseInsecureSSL(false);
            //指定url
            int a=20180718;
            int b=97;
            for (int i = 0; i < 20180719; i++) {
               one:for (int j = 0; j < 20; j++) {
                    for (int k = 1; k <20 ; k++) {
                        String url = "https://www.soxtu.com/upload/photos/tu/10049/"+(a+i)+"/"+((char)(b+j))+"/"+StringUtils.leftPad(k+"", 3,"0")+".jpg";
                        WebRequest request = new WebRequest(new URL(url), HttpMethod.GET);
                        //设置请求头, 添加请求头里面的一些参数
                        Map additionalHeaders = new HashMap();
                        additionalHeaders.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
                        //把请求头放入 请求里面去
                        request.setAdditionalHeaders(additionalHeaders);



                        try {
                            Page page = webClient.getPage(request);
                            System.out.println(page.getWebResponse().getContentAsStream());
                            InputStream inStream = page.getWebResponse().getContentAsStream();
                            byte data[] = readInputStream(inStream);
                            inStream.read(data);
                            inStream.close();
                            FileOutputStream fs =new FileOutputStream(System.getProperty("user.dir")+ File.separator+"/image/"+(a+i)+(char)(b+j)+k+".jpg");
                            fs.write(data);
                            fs.flush();
                            fs.close();
                        } catch (Exception e) {
                            if (k==1){
                                break one;
                            }else {
                                break;
                            }
                        }
                    }


                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }


    @Test
    public void testa(){
        System.out.println((char)100);
    }

}
