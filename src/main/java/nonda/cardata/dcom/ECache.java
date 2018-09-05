package nonda.cardata.dcom;

import org.springframework.util.StringUtils;

//分布式缓存（基于redis）
//添加用于高并发白名单（常规key-value应用可自行添加）
//add by tom 2018/8/1
public class ECache {
    //设定hash缓存 for 字符串
    public static boolean hset(String cacheKey,String field,String cacheValue) {
        try {
            JedisUtil.hset(cacheKey, field, cacheValue);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    //设置hash缓存 for 实体
    public static boolean hset(String cacheKey,String field,Object objectValue){
        try {
            String strValue = ObjectUtil.toJSON(objectValue);
            JedisUtil.hset(cacheKey,field,strValue);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();;
            return false;
        }
    }
    //获取hash缓存值 for 字符串
    public static String hget(String cacheKey,String field){
        return JedisUtil.hget(cacheKey,field);
    }
    //获取hash缓存值 for 实体
    public static <T> T hget(String cacheKey,String field,Class<T> tClass) {
        String strValue = JedisUtil.hget(cacheKey, field);
        if (StringUtils.isEmpty(strValue)) return null;
        return ObjectUtil.parse(strValue, tClass);
    }
    //清理缓存
    public static void hdel(String cacheKey,String field){
        JedisUtil.hdel(cacheKey,field);
    }
}
