package nonda.cardata.dcom;

import org.springframework.util.StringUtils;

//分布式队列（基于redis） by tom 2018/8/1
public class EQueue {
    //入队方法
    public static boolean push(String queueKey,String message) {
        try {
            JedisUtil.lpush(queueKey, message);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //入队方法
    public static boolean push(String queueKey,Object objectValue) {
        try {
            JedisUtil.lpush(queueKey, ObjectUtil.toJSON(objectValue));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //出队方法
    public static String  pop(String queueKey) {
        try {
            String value = JedisUtil.rpop(queueKey);
            return value;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //出队方法
    public static <T> T  pop(String queueKey,Class<T> tClass) {
        try {
            String value = JedisUtil.rpop(queueKey);
            if(StringUtils.isEmpty(value))return null;
            return ObjectUtil.parse(value, tClass);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
