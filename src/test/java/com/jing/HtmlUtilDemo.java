package com.jing;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import hirondelle.date4j.DateTime;
import nonda.cardata.httputil.APIService;
import nonda.cardata.httputil.HttpResult;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.helpers.ISO8601DateFormat;
import org.apache.poi.util.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlUtilDemo {

    @Test
    public void a4(){
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DDTHH:mm:ss.mmm");
        ISO8601DateFormat.getDateInstance();
        System.out.println(sdf.format(new Date()));
    }

    @Test
    public void a3(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar rightNow = Calendar.getInstance();
        rightNow.add(Calendar.DATE, -90);
        System.out.println((rightNow.getTimeInMillis()-new Date().getTime())/60/60/24/1000);

        Date date=new Date();
        System.out.println(date.getTime());
        int a=1;
        a:do{
            for (int i = 0; i < 5; i++) {
                System.out.println(rightNow.getTime());
                a++;
                if (rightNow.getTimeInMillis()>date.getTime()){
                    break a;
                }
            }
        }while (a<5);

        System.out.println("a");
    }


    //成功请求到新增
    @Test
    public void a1()throws Exception{
//        WebRequest webRequest=new WebRequest("", HttpMethod.POST);
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://sellercentral.amazon.com/payments/reports/custom/submit/generateReports");
        String json ="{\"reportType\":\"Transaction\",\"timeRangeType\":\"Custom\",\"startDate\":{\"date\":27,\"month\":7,\"year\":2018},\"endDate\":{\"date\":27,\"month\":7,\"year\":2018}}";
        StringEntity postingString = new StringEntity(json,"application/json","UTF-8");
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json; UTF-8");
//        post.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        post.setHeader("Accept-Encoding", "gzip, deflate, br");
        post.setHeader("Accept-Language", "zh-CN,zh;q=0.9,zh-TW;q=0.8,en;q=0.7");
        post.setHeader("Connection", "keep-alive");
        post.setHeader("Cookie", "sid=\"rtkTo9vrSHsGftXUJ5l9sw==|pwLzA/20Tw152xe8PR64qVIQ81mUHt8t2YJEIG1Mkaw=\"; s_pers=%20s_ev15%3D%255B%255B%2527Typed/Bookmarked%2527%252C%25271532152120040%2527%255D%255D%7C1689918520040%3B%20s_dl%3D1%7C1532153983749%3B%20gpv_page%3DUS%253ASC%253A%2520SellerCentralLogin%7C1532153983757%3B; at-main=Atza|IwEBIAr-4XHt_2XqltY2IZZsBsMlmyUvRHbPAsz0qRj_f2ZAQMXOXokBkWv2sLGzS3f6Iwu11uGpCHXTOuc7W3KmlZqzTfVC_qvbnjmakPaHNLYN2UxZLueJDqlmQKisr_b_xdkhz_6Co4fUrnuYoExLa0rB7SRaSABsl2e3busn8aSWkL7-ytHneobRovEjHloL8IUmk2vZyUFjXIgEAyfS_IL_cCCOihsQO3okiXXr743h0zzeN8uBq0f5BjDcMuza9UYUjjluMoygARb65RP-5Hu5D31G6QYul9t8Oyb66yCbpTMhf25jLFKIs1QT5GCS71aNgqR6cMuxeBXEKfpsjwPWAuiz7csCfU63ktfQjLkEofagB1TMQVdf2oIhg6-r8NxKhx2aKyX_oSXu1VpPLGN6dd3xbFx233OwtDyYAkzkFg; sess-at-main=\"s4ik7fN6+QtaK/pZ9+eLdmcERjmPLF2qccYdwh+4+Fw=\"; sst-main=Sst1|PQHdWeqHEOtUcAHDG1Lr99ipCwcAIIrrdBug7U_0jGoH6qUgRq0eIcZXVXpLbRdibp6e5HGb-sk3xPsswZqeHRvi9UznLztuHUzwv4Tfs93VcN8BoTh359_0vexaro2N8nl0mwcqzGa4sOmHBYWKGhIr693mElEXVHQqk3rdSR--A2_Cad_C27Tl4BBXtNUZk5oX_DUGn-HAR0pwlIndFJ9BJTK35xrn-Uu16YdA4enAcACAzzZiqqAJ4-rAGwNhZ5CQQEjBWMXIWeNe-3INKLSPfqQDy2ed2A3kheBWnhO5b7XG0fuvMxkKsjhqFmBXSBDjnEI576dKOPsx7JDRLNr4xw; s_sess=%20c_m%3DundefinedTyped/BookmarkedTyped/Bookmarked%3B%20s_cc%3Dtrue%3B%20s_sq%3Dwebstoreamznhelpandeducation%253D%252526pid%25253Dhttps%2525253A//sellercentral.amazon.com/gp/payments-account/view-transactions.html%2525253Fview%2525253Dfilter%25252526groupId%2525253D3FW4cuZGvxDGBCm_IvyN7ztwPr17KWA491nGHbDe2FM%25252526subview%2525253Dgroups%25252526pageSize%2525253D50%25252526x%2525253D10%25252526y%2525253D15%252526oid%25253Dhttps%2525253A//sellercentral.amazon.com/payments/reports/custom/request%252526ot%25253DA%3B; session-id-time=2082787201l; session-id=141-9714414-2644806; ubid-main=132-8229529-9126164; session-token=\"pHSt952DgoKEgluvNVL2NMRXHJpsc8xEUJ/W13kTbU9Ck06lA5GdLq7H93PjtydseE5Kk2wD3vvFbTpVX8O7F8mpHgxhnqncPPKkD1XQkVyaXrQdnGGcPZcPPeLKfH4zVi59WpcE1yfl9BmgEKmHKK/6N3ynfnwh2ckcPX3GvtKor2WMkJHOZbnawHn7i5PVANVLhE/DByTWzoRimwXjMBtjS5RVyQkUUIdgimrk/S0=\"; x-main=6rAPtDitZtZCtGbxyNgZnGm9AeUo5YfeRXg73Sxo6xySImdXKgNlrurfZ7KWnXR8; csm-hit=sa-FNPT5Y8CZ5RT9XNV2FJ1-3RC40ARPK6WHJJQT8TDN|1532505842055");
        post.setHeader("Host", "sellercentral.amazon.com");
        post.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        post.setHeader("Origin","https://sellercentral.amazon.com");
        post.setHeader("Upgrade-Insecure-Requests", "1");
        HttpResponse response = httpClient.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity(),"UTF-8"));
    }


    //测试登录
    @Test
    public void a2()throws Exception{
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://sellercentral.amazon.com/ap/signin");


        //        表单方式
        List<BasicNameValuePair> pairList = new ArrayList<BasicNameValuePair>();
        pairList.add(new BasicNameValuePair("appActionToken", "6PhX4hZi5CWfm4SEtkEgGhjzg7Qj3D"));
        pairList.add(new BasicNameValuePair("appAction", "SIGNIN"));
        pairList.add(new BasicNameValuePair("openid.pape.max_auth_age", "ape:MTgwMDA="));
        pairList.add(new BasicNameValuePair("openid.identity", "ape:aHR0cDovL3NwZWNzLm9wZW5pZC5uZXQvYXV0aC8yLjAvaWRlbnRpZmllcl9zZWxlY3Q="));
        pairList.add(new BasicNameValuePair("ssoResponse", "ape:ZXlKNmFYQWlPaUpFUlVZaUxDSmxibU1pT2lKQk1qVTJSME5OSWl3aVlXeG5Jam9pUVRJMU5rdFhJbjAuVVhKVWRHdEdGZ3JnalJhd29ZNXBoSVlnZUJVSWVWTnowdVVSOUNCSFZHelkzNEM5LXp6bFFnLlpFbGpWUl9xV3ZYX3gzenouSnFsSWhMVmVjQVM1VVZoMWJlc0NSN2h4a19zQk5rS0gyYndjOHNMZWxWYklBb0txdmlJUnU3X3ItMk9KMk1URlI4NkRkZmMtTmRPT2NRWlNzbDdYdEVUczdkNnNlVlJ4ZE5mdjZxYXFvNEVTelVhZXZLN05DekF3aE5Bemd4V2RwNFh5TmtVLWQyTElfSWRfUXdPb1oyWVhzRm95SFpybzRsTUxPS0dhbFRsV3FJVVM3U1ZIN0NEZV96OVdyNDF3UmhOY1NLNnZLaFpqRDJhc3V5RTJtbjg0Y1BrbEREbk1ZaF9TYTZYU1g5U29HNkk2RWkwdklTaUU5RS1rZHRMRk5lcjNzMjUyWUJCclRiOFZQWEtNVTA5bDROR2t4UXV4eEJRLnJwS0JieWdfN3BOS3BqaXRxUzBDbGc="));
        pairList.add(new BasicNameValuePair("language", "ape:emhfQ04="));
        pairList.add(new BasicNameValuePair("pageId", "ape:c2NfbmFfYW1hem9uX3Yy&openid.return_to=ape:aHR0cHM6Ly9zZWxsZXJjZW50cmFsLmFtYXpvbi5jb20vZ3AvaG9tZXBhZ2UuaHRtbD9jb3I9bG9naW5fTkE="));
        pairList.add(new BasicNameValuePair("prevRID", "ape:QzZNV1BOOTlEQ1NWQ1k2NEhCSkY="));
        pairList.add(new BasicNameValuePair("openid.assoc_handle", "ape:c2NfbmFfYW1hem9uX3Yy"));
        pairList.add(new BasicNameValuePair("openid.mode", "ape:Y2hlY2tpZF9zZXR1cA=="));
        pairList.add(new BasicNameValuePair("openid.ns.pape", "ape:aHR0cDovL3NwZWNzLm9wZW5pZC5uZXQvZXh0ZW5zaW9ucy9wYXBlLzEuMA=="));
        pairList.add(new BasicNameValuePair("prepopulatedLoginId", ""));
        pairList.add(new BasicNameValuePair("failedSignInCount", "ape:MA=="));
        pairList.add(new BasicNameValuePair("openid.claimed_id", "ape:aHR0cDovL3NwZWNzLm9wZW5pZC5uZXQvYXV0aC8yLjAvaWRlbnRpZmllcl9zZWxlY3Q="));
        pairList.add(new BasicNameValuePair("openid.ns", "ape:aHR0cDovL3NwZWNzLm9wZW5pZC5uZXQvYXV0aC8yLjA="));
        pairList.add(new BasicNameValuePair("create", "0"));
        pairList.add(new BasicNameValuePair("email", "ecommerce@nonda.us"));
        pairList.add(new BasicNameValuePair("password", "Nonda828!2016"));
        post.setEntity(new UrlEncodedFormEntity(pairList, "utf-8"));


        post.setHeader("Content-type", "application/json; UTF-8");
//        post.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        post.setHeader("Accept-Encoding", "gzip, deflate, br");
        post.setHeader("Accept-Language", "zh-CN,zh;q=0.9,zh-TW;q=0.8,en;q=0.7");
        post.setHeader("Connection", "keep-alive");
        post.setHeader("Cookie", "signin-sso-state-us=5e35bd25-b65a-4e85-a36d-1a63c0cdf3d2; sid=\"rtkTo9vrSHsGftXUJ5l9sw==|pwLzA/20Tw152xe8PR64qVIQ81mUHt8t2YJEIG1Mkaw=\"; s_pers=%20s_ev15%3D%255B%255B%2527Typed/Bookmarked%2527%252C%25271532152120040%2527%255D%255D%7C1689918520040%3B%20s_dl%3D1%7C1532153983749%3B%20gpv_page%3DUS%253ASC%253A%2520SellerCentralLogin%7C1532153983757%3B; s_sess=%20c_m%3DundefinedTyped/BookmarkedTyped/Bookmarked%3B%20s_cc%3Dtrue%3B%20s_sq%3Dwebstoreamznhelpandeducation%253D%252526pid%25253Dhttps%2525253A//sellercentral.amazon.com/gp/payments-account/view-transactions.html%2525253Fview%2525253Dfilter%25252526groupId%2525253D3FW4cuZGvxDGBCm_IvyN7ztwPr17KWA491nGHbDe2FM%25252526subview%2525253Dgroups%25252526pageSize%2525253D50%25252526x%2525253D10%25252526y%2525253D15%252526oid%25253Dhttps%2525253A//sellercentral.amazon.com/payments/reports/custom/request%252526ot%25253DA%3B; session-id=141-9714414-2644806; ubid-main=132-8229529-9126164; sst-main=Sst1|PQGMHQySRO3kDS1X4NVnlvN-B3PaL35fiuZD40UfXiUV2M7eKmJ24TXHGjoIJh_UJO06M0gPLKQuC-4B-FuCL7cvUaCQg9mtxfeEnKP0K_0GZZqe-QrWCGnFdtH7ltIx8-JSz7pryUMcdxKP8LLV8HSiDMYGsQkVFNuufGT4HLkSzXy5R0qfRfsn0IEIPVT74QndKGlfPF7b5VVZk4Jjabgz8LF7_4bCs2qapIGxRf6bX5XgblUiMdYtecDFHUHPNNvo; session-token=\"W+pzrjoItDalZ5Us3JQDXeUpfnNFPg0xSSYfx3V/ehQUW2HsqcwkQE92Uv9zFUSjnX9eJW/1esY8DHvx/MEn+VwDY9m6Lzv673RcnVbxwUpWk464Fdq+8g+KMjOTpTeSzWjQ4pRzffbxd9TgPir//SdYLimnXnyPeBIhWgAuOD6lC6V+K7mslgLidC7piZZASv3JP9ybqLDVfLVKlHzIIA==\"; session-id-time=2163291338l; csm-hit=DNT6XNEKKXJJF6PN1TRR+s-C6MWPN99DCSVCY64HBJF|1532571929504");
        post.setHeader("Host", "sellercentral.amazon.com");
        post.setHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        post.setHeader("Origin","https://sellercentral.amazon.com");
        post.setHeader("Upgrade-Insecure-Requests", "1");


        HttpResponse response = httpClient.execute(post);
        HtmlPage page=(HtmlPage) response.getEntity();
        System.out.println(page.getBody());
    }

    @Test
    public void amazontest()throws Exception{
        //创建浏览器, 并设置一些参数
        WebClient webclient = new WebClient();
        webclient.getOptions().setJavaScriptEnabled(false);
        webclient.getOptions().setCssEnabled(false);
        webclient.getOptions().setUseInsecureSSL(false);
        //创建浏览器, 并设置一些参数
        //指定url
        String url = "https://sellercentral.amazon.com/payments/reports/custom/request?tbla_daterangereportstable=sort:%7B%22sortOrder%22%3A%22DESCENDING%22%7D;search:undefined;pagination:3;#next";
        WebRequest request = new WebRequest(new URL(url), HttpMethod.GET);
        //设置请求头, 添加请求头里面的一些参数
        Map additionalHeaders = new HashMap();
        additionalHeaders.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        additionalHeaders.put("Accept-Encoding", "gzip, deflate, br");
        additionalHeaders.put("Accept-Language", "zh-CN,zh;q=0.9,zh-TW;q=0.8,en;q=0.7");
        additionalHeaders.put("Connection", "keep-alive");
        additionalHeaders.put("Cookie", "sid=\"rtkTo9vrSHsGftXUJ5l9sw==|pwLzA/20Tw152xe8PR64qVIQ81mUHt8t2YJEIG1Mkaw=\"; s_pers=%20s_ev15%3D%255B%255B%2527Typed/Bookmarked%2527%252C%25271532152120040%2527%255D%255D%7C1689918520040%3B%20s_dl%3D1%7C1532153983749%3B%20gpv_page%3DUS%253ASC%253A%2520SellerCentralLogin%7C1532153983757%3B; s_sess=%20c_m%3DundefinedTyped/BookmarkedTyped/Bookmarked%3B%20s_cc%3Dtrue%3B%20s_sq%3Dwebstoreamznhelpandeducation%253D%252526pid%25253Dhttps%2525253A//sellercentral.amazon.com/gp/payments-account/past-settlements.html%252526oid%25253Dhttps%2525253A//sellercentral.amazon.com/payments/reports/custom/request%252526ot%25253DA%3B; at-main=Atza|IwEBIBUFVtfeUjWW0KKZ9oUDNt4bzQFkIRXfBJNLS9ekm_85-1mLvdCyQzGYFVo3ujiigQ4JHQmyY1WMljv4VN4ZJkSX-0-xHeCoKOlIlrw_vY8Luvc3w0ZRKkwsu1hGDDG0TovtbKRdBaL-T0dtxLA-EePUA_QLhzi9pdSFr65PR5nGJw6keEqNxfK9Pd3IwSL9kgCq9FnCKvyAlLVR49y-7KZBFClz3Qq1-K1LpQHYmkg73h-VFjSYC98lrTSBojVcaq9OALLYRp9EI63oSGCkp-4uExGZDfEmIdB_y07n-T7HyD3jxrNL3exZX4Hf9PhuSdaxu3hfEKsyMaYU23tzAR-lfW3Wzv3xEuBDJ6B71tg0u89jEqLLCTyT8UUJj9OJ6jh4-UN9QwEL7uRWkCc_ligziR5MfpqV4XtTQOTcXZoPlA; sess-at-main=\"3Sa2IKPATUrbPya33mVIka10kTQwILZwW1y028ibCmI=\"; sst-main=Sst1|PQGBkeRCb86SHELzgCcWlCu4C9iuudol9bN5OyG1BzSo_2eDxrJ-r7-Yx6asUxt2YAxh_ahMxugXfA1JHp6ZdWwbq8z0_CrUlhLq4btgnOIJnfNACuJfKCOP-SWOi0BVRQwPyfOZ8YhFGCalN7XGkzvPdpY8LkLgnqnYZmLUZddzT8ZEsNLNtXkWdiosq5_WKg4tWU2TFKg57jZuHIR54d_czWXa408SUz8pBq9lnjm13G6KS_ppO6lMuK_HDY2FfupDieJoX6EnDOi-Sl0C2fSVlO6ardefeV0gfvVSKw7ezC2Rrif68PqcP_M7XvjoX2QBqxbgF1gavoEqX1uXeXCbAQ; session-id-time=1533020400l; session-id=141-9714414-2644806; ubid-main=132-8229529-9126164; x-main=\"v5p3gJXTpjdK6shubvzt7tPogSZB?IMneTsVSpz@?bHMZbl9c5NrZxK?GWo2xiFr\"; csm-hit=sa-T7Q8G1YNR4B15Z4GFJ5R-DSYRMAPG8ENAS3B14DH0|1532482276750");
        additionalHeaders.put("Host", "sellercentral.amazon.com");
        additionalHeaders.put("Upgrade-Insecure-Requests", "1");

//        把请求头放入 请求里面去
        request.setAdditionalHeaders(additionalHeaders);
        HtmlPage page = webclient.getPage(request);





//        String generateUrl="https://sellercentral.amazon.com/payments/reports/custom/submit/generateReports";
//        WebRequest generaterequest=new WebRequest(new URL(generateUrl),HttpMethod.POST);
//        generaterequest.setAdditionalHeaders(additionalHeaders);
//        List<com.gargoylesoftware.htmlunit.util.NameValuePair> requestParameters =new ArrayList<>( );
//        requestParameters.add(new com.gargoylesoftware.htmlunit.util.NameValuePair("reportType", "Transaction"));
//        requestParameters.add(new com.gargoylesoftware.htmlunit.util.NameValuePair("timeRangeType", "Custom"));
//        requestParameters.add(new com.gargoylesoftware.htmlunit.util.NameValuePair("startDate", "{\"date\":25,\"month\":7,\"year\":2018}"));
//        requestParameters.add(new com.gargoylesoftware.htmlunit.util.NameValuePair("endDate", "{\"date\":25,\"month\":7,\"year\":2018}"));
//        generaterequest.setRequestParameters(requestParameters);
//        webclient.getPage(generaterequest);




        //先获取所有的a标签
        DomNodeList<DomElement> htmlElements = page.getElementsByTagName("a");
        DomNodeList<DomElement> liElements = page.getElementsByTagName("li");
        DomNodeList<DomElement> subElements= page.getElementsByTagName("input");
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        HtmlRadioButtonInput radio1=null;
        HtmlRadioButtonInput radio2=null;
        HtmlInput fromDate=null;
        HtmlInput toDate=null;
        HtmlSubmitInput submitInput=null;
        HtmlSubmitInput submitInput2=null;
        for (DomElement domElement:subElements){
            if (domElement.getAttribute("aria-labelledby").equals("drrGenerateReportButton-announce")){
                submitInput2=(HtmlSubmitInput) domElement;
                submitInput2.click();
            }
            if (domElement.getAttribute("id").equals("drrReportRangeTypeRadioMonthly")){
                radio1=(HtmlRadioButtonInput) domElement;
                radio1.setAttribute("checked","false");
            }
            if (domElement.getAttribute("id").equals("drrReportRangeTypeRadioCustom")){
                radio2=(HtmlRadioButtonInput) domElement;
                radio2.setAttribute("checked","true");
            }

            if (domElement.getAttribute("id").equals("drrFromDate")){
                 fromDate=(HtmlInput) domElement;
                fromDate.setValueAttribute(sdf.format(DateUtils.addDays(new Date(), 1)));
            }
            if (domElement.getAttribute("id").equals("drrToDate")){
                toDate=(HtmlInput) domElement;
                toDate.setValueAttribute(sdf.format(DateUtils.addDays(new Date(), 1)));
            }
            if (domElement.getAttribute("aria-labelledby").equals("drrGenerateReportsGenerateButton-announce")){
                submitInput=(HtmlSubmitInput) domElement;
            }
        }
        System.out.println(submitInput.click().getUrl());


        for (int i = 0; i < 21; i++) {
//            for (DomElement domElement : htmlElements) {
//                //判断每个节点的id是否为我想要的
//                if (domElement.getAttribute("id").equals("downloadButton-announce")) {
//                    WebRequest request1 = new WebRequest(domElement.click().getUrl(), HttpMethod.GET);
//
//                    Page page1 = webclient.getPage(request1);
//                    InputStream is = page1.getWebResponse().getContentAsStream();
//                    Date date = new Date();
//                    String uri = date + "reports.csv";
//                    FileOutputStream output = new FileOutputStream(uri);
//                    IOUtils.copy(is, output);
//                    output.close();
//                    File file = new File(uri);
//
//                    // 创建CSV读对象
////                    CsvReader csvReader = new CsvReader(file.toString());
//
//                    int j = 1;
////                    while (csvReader.readRecord()){
////                        // 读一整行
////                        if (j>8) {
////                            if (iAmazonReportsService.count(null, csvReader.get(3), null, null,null ,null , null,null )==0) {
////                                AmazonReports amazonReports = new AmazonReports();
////                                amazonReports.setId(UUIDHelper.getUUID32());
////                                // 读这行的某一列
////                                System.out.println(csvReader.get(0));
//////                            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////                                amazonReports.setDatetime(csvReader.get(0));
////                                System.out.println(csvReader.get(1));
////                                amazonReports.setSettlementID(csvReader.get(1));
////                                System.out.println(csvReader.get(2));
////                                amazonReports.setOrderType(csvReader.get(2));
////                                System.out.println(csvReader.get(3));
////                                amazonReports.setOrderID(csvReader.get(3));
////                                System.out.println(csvReader.get(4));
////                                amazonReports.setSku(csvReader.get(4));
////                                System.out.println(csvReader.get(5));
////                                amazonReports.setDescription(csvReader.get(5));
////                                System.out.println(csvReader.get(6));
////                                try {
////                                    amazonReports.setQuantity(new DecimalFormat().parse(csvReader.get(6)).intValue());
////                                } catch (Exception e) {
////                                    e.printStackTrace();
////                                }
////                                System.out.println(csvReader.get(7));
////                                amazonReports.setMarketplace(csvReader.get(7));
////                                System.out.println(csvReader.get(8));
////                                amazonReports.setFulfillment(csvReader.get(8));
////                                System.out.println(csvReader.get(9));
////                                amazonReports.setOrderCity(csvReader.get(9));
////                                System.out.println(csvReader.get(10));
////                                amazonReports.setOrderState(csvReader.get(10));
////                                System.out.println(csvReader.get(11));
////                                amazonReports.setOrderPostal(csvReader.get(11));
////                                System.out.println(csvReader.get(12));
////                                amazonReports.setProductSales(new DecimalFormat().parse(csvReader.get(12)).doubleValue());
////                                System.out.println(csvReader.get(13));
////                                amazonReports.setShippingCredits(new DecimalFormat().parse(csvReader.get(13)).doubleValue());
////                                System.out.println(csvReader.get(14));
////                                amazonReports.setGiftWrapCredits(new DecimalFormat().parse(csvReader.get(14)).doubleValue());
////                                System.out.println(csvReader.get(15));
////                                amazonReports.setSalesTaxCollected(new DecimalFormat().parse(csvReader.get(15)).doubleValue());
////                                System.out.println(csvReader.get(16));
////                                amazonReports.setMarketplaceFacilitatorTax(new DecimalFormat().parse(csvReader.get(16)).doubleValue());
////                                System.out.println(csvReader.get(17));
////                                amazonReports.setMarketplaceFacilitatorTax(new DecimalFormat().parse(csvReader.get(17)).doubleValue());
////                                System.out.println(csvReader.get(18));
////                                amazonReports.setSellingFees(new DecimalFormat().parse(csvReader.get(18)).doubleValue());
////                                System.out.println(csvReader.get(19));
////                                amazonReports.setFbaFees(new DecimalFormat().parse(csvReader.get(19)).doubleValue());
////                                System.out.println(csvReader.get(20));
////                                amazonReports.setOtherTransactionFees(new DecimalFormat().parse(csvReader.get(20)).doubleValue());
////                                System.out.println(csvReader.get(21));
////                                amazonReports.setOther(new DecimalFormat().parse(csvReader.get(21)).doubleValue());
////                                System.out.println(csvReader.get(22));
////                                amazonReports.setTotal(new DecimalFormat().parse(csvReader.get(22)).doubleValue());
////                                iAmazonReportsService.insert(amazonReports);
////                            }
////
////                        }
////
////                        j++;
////                    }
//                    Thread.sleep(1000 * 3);
//                }
//            }

            for (DomElement domElement : liElements) {
                //判断每个节点的id是否为我想要的
                if (domElement.getAttribute("class").equals("a-last")) {
                    HtmlButton button = (HtmlButton) domElement.getFirstElementChild();
                    page = button.click();
//                    WebRequest request1 = new WebRequest(.click().getUrl(), HttpMethod.GET);
//                    request1.setAdditionalHeaders(additionalHeaders);
//                    page =  webClient.getPage(request1);
                    break;

                }
            }


        }
    }

    @Test
    public void baidutest() throws IOException {
            WebClient webClient = new WebClient();
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setUseInsecureSSL(false);
            int page=1;
           String url2 ="http://oms.4px.com/queryrecallorder.html?objReceivingOrderVo.pageNumber="+page+"&objReceivingOrderVo.pageSize=500";
           WebRequest request2 = new WebRequest(new URL(url2), HttpMethod.GET);
           Map<String, String> additionalHeaders2 = new HashMap<>();
           additionalHeaders2.put("Cookie", "SESSION_COOKIE=app1inst2; oms2_do_doh_code=; oms2_do_ref_code=; oms2_do_ship_code=; oms2_do_upload_data_code=; oms2_do_ref_code_platform=; oms2_do_consignee_fullname=; oms2_do_item_serialnumber=; oms2_do_platform_code=; oms2_do_wh_code=; oms2_do_country_code_temp=; oms2_do_ship_chnl_seller=; oms2_do_oda=; oms2_do_date_ship_begin=; oms2_do_date_ship_end=; Hm_lvt_bd0f4b5e3fdc16830173a2ed0671a28a=1530503355; Hm_lpvt_bd0f4b5e3fdc16830173a2ed0671a28a=1530503355; oms2_ro_roReferenecode=; oms2_ro_shipping_code=; oms2_ro_imSku=; oms2_ro_pkCode=; oms2_ro_wh_code_destination=; oms2_ro_roCode=; __cfduid=d216b064d253baf254e7e14912414eb5e1530521582; _qddaz=QD.3kxs5d.5jrlcy.jj4118i3; pgv_pvi=5655892992; pgv_si=s2720676864; oms2_do_item_code=; oms2_do_date_create_begin=2018-06-01; oms2_do_date_create_end=2018-06-30%2023%3A59%3A59; oms2_ro_roCreateBeginDate=2018-06-01; oms2_ro_roCreateEndDate=2018-06-30; JSESSIONID=4E7C565B82C93F4185A8BC630551EE6A; $menuB_cookieId=newdo_1002004");
           request2.setAdditionalHeaders(additionalHeaders2);
           HtmlPage page2 = webClient.getPage(request2);
           HtmlTable table= page2.getHtmlElementById("tableReceiving");
           for (HtmlTableRow row : table.getRows()) { // 遍历所有行
               HtmlTableCell cell=row.getCell(0);
               for (DomNode domNode :cell.getChildren()){
                   if (domNode.toString().indexOf("<a")!=-1) {
                       String source = domNode.toString();
                       List<String> list = match(source, "a", "name");
                       System.out.print("name==>"+list.get(0));
                       System.out.println("order==>"+cell.asText() + " ");

                       String url="http://oms.4px.com/queryrecorderdetail.html?objRecOrderVo.roId="+list.get(0)+"&objRecOrderVo.roCode="+cell.asText();
                       WebRequest request = new WebRequest(new URL(url), HttpMethod.GET);
                       Map<String, String> additionalHeaders = new HashMap<>();
                       additionalHeaders.put("Cookie", "SESSION_COOKIE=app1inst2; oms2_do_doh_code=; oms2_do_ref_code=; oms2_do_ship_code=; oms2_do_upload_data_code=; oms2_do_ref_code_platform=; oms2_do_consignee_fullname=; oms2_do_item_serialnumber=; oms2_do_platform_code=; oms2_do_wh_code=; oms2_do_country_code_temp=; oms2_do_ship_chnl_seller=; oms2_do_oda=; oms2_do_date_ship_begin=; oms2_do_date_ship_end=; Hm_lvt_bd0f4b5e3fdc16830173a2ed0671a28a=1530503355; Hm_lpvt_bd0f4b5e3fdc16830173a2ed0671a28a=1530503355; oms2_ro_roReferenecode=; oms2_ro_shipping_code=; oms2_ro_imSku=; oms2_ro_pkCode=; oms2_ro_wh_code_destination=; oms2_ro_roCode=; __cfduid=d216b064d253baf254e7e14912414eb5e1530521582; _qddaz=QD.3kxs5d.5jrlcy.jj4118i3; pgv_pvi=5655892992; pgv_si=s2720676864; oms2_do_item_code=; oms2_do_date_create_begin=2018-06-01; oms2_do_date_create_end=2018-06-30%2023%3A59%3A59; JSESSIONID=4E7C565B82C93F4185A8BC630551EE6A; oms2_ro_roCreateBeginDate=2018-01-01; oms2_ro_roCreateEndDate=2018-07-03; $menuB_cookieId=newdo_1002004");
                       request.setAdditionalHeaders(additionalHeaders);
                       HtmlPage page1 = webClient.getPage(request);

                       DomNodeList<DomNode> divs = page1.querySelectorAll("div");

                           List<DomNode> table1=divs.get(59).querySelectorAll("table");
                       for (int i = 0; i <table1.size() ; i++) {
                           HtmlTable table2=(HtmlTable) table1.get(i);

                           for (HtmlTableRow row1:table2.getRows()){
                               for (HtmlTableCell cell1:row1.getCells()){
                                   System.out.println(cell1.asText());
                               }
                           }
                           
                       }







                   }
               }

           }



    }

    @Test
    public void stringvalOf() throws Exception{
        HttpClient httpClient = new DefaultHttpClient();
        //  查询单个入库单  http://apisandbox.4px.com/api/service/woms/receiving/getReceivingOrder
        HttpPost post = new HttpPost("http://openapi.4px.com/api/service/woms/receiving/getReceivingOrder?customerId=560772&token=1ebd603009de06b9d49bf82185572e40&language=en_US&receivingCode=RCV150914-2074");
        //查询入库单集合
//        HttpPost post = new HttpPost("http://openapi.4px.com/api/service/woms/receiving/getReceivingOrderList?customerId=560772&token=1ebd603009de06b9d49bf82185572e40&language=en_US");
        String json ="{}";
        StringEntity postingString = new StringEntity(json);
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(post);
        String content = EntityUtils.toString(response.getEntity());
        System.out.println(content);

    }

    /**
     * 获取指定HTML标签的指定属性的值
     * @param source 要匹配的源文本
     * @param element 标签名称
     * @param attr 标签的属性名称
     * @return 属性值列表
     */
    public static List<String> match(String source, String element, String attr) {
        List<String> result = new ArrayList<>();
        String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?(\\s.*?)?>";
        Matcher m = Pattern.compile(reg).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result.add(r);
        }
        return result;
    }

}
