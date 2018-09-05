package nonda.cardata.dcom;


import com.alibaba.fastjson.JSON;

import java.io.*;

public class ObjectUtil {

    //实体转换为字符串
    public static String toJSON(Object obj) {
        try {
            String json = JSON.toJSONString(obj);;
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //字符串转换为实体
    public static <T> T parse(String jsonStr,Class<T> clazz) {
        T readValue = null;
        try {
            readValue = JSON.parseObject(jsonStr,clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readValue;
    }



    /**
     * 对象转byte[]
     * @param obj
     * @return
     * @throws IOException
     */
    public static byte[] object2Bytes(Object obj) throws IOException{
        ByteArrayOutputStream bo=new ByteArrayOutputStream();
        ObjectOutputStream oo=new ObjectOutputStream(bo);
        oo.writeObject(obj);
        byte[] bytes=bo.toByteArray();
        bo.close();
        oo.close();
        return bytes;
    }
    /**
     * byte[]转对象
     * @param bytes
     * @return
     * @throws Exception
     */
    public static Object bytes2Object(byte[] bytes) throws Exception{
        ByteArrayInputStream in=new ByteArrayInputStream(bytes);
        ObjectInputStream sIn=new ObjectInputStream(in);
        return sIn.readObject();
    }
}
