package com.jing;

import org.junit.Test;

import java.util.*;

public class yunchiiot {

    @Test
    public void a1(){
        String key="2F9577AE-37CE-1154-205D-E949A79F2667";
        Map<String, String> params = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj2.compareTo(obj1);
                    }
                });

        params.put("iccid", "89860618000034594676");
        params.put("pkg_type", "0");
        params.put("cycle", "1");
        params.put("restkey", "4805de5d0622a80edcf5a504ade20694");
        params.put("appid", "2F9577AE-37CE-1154-205D-E949A79F2667");
        String b=signForInspiry(params, key);

        System.out.println(b);
    }

    static public String signForInspiry(Map params, String key) {

        StringBuffer sbkey = new StringBuffer();
        Set es = params.entrySet();
        Iterator it = es.iterator();

        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            //空值不传递，不参与签名组串
            if (null != v && !"".equals(v)) {
                sbkey.append(k + "=" + v + "&");
            }
        }

        sbkey = sbkey.append("appid=" + key);

        return sbkey.toString();
    }

    public static String ASCIISort(String str) {
        char[] test = new char[str.length()];
        StringBuilder sb = new StringBuilder();
        while (true) {
            String a = str;//直接读取这行当中的字符串。
            for (int i = 0; i < str.length(); i++) {
                test[i] = a.charAt(i);//字符串处理每次读取一位。
            }
            Arrays.sort(test);
            for (int i = test.length-1; i >=0; i--) {
                sb.append(test[i]);
            }
            String trim = sb.toString().trim();
            return trim;
        }
    }

}
