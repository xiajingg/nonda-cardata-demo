package nonda.cardata.dcom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

import java.util.List;
import java.util.Map;
import java.util.Set;

//jedis工具原始类（如果需要放开功能  需要在application.yml配置redis节点"spring.redis"，并放开@Configuration注解 ）
//用于collector异步分析用 by tom 2018/8/1
@Configuration
public class JedisUtil {
    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisPool getJedisPool() {
        if (jedisPool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(8);
            config.setMaxIdle(4);
            config.setMinIdle(4);
            config.setMaxWaitMillis(10000);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            //Idle时进行连接扫描
            config.setTestWhileIdle(true);
            //表示idle object evitor两次扫描之间要sleep的毫秒数
            config.setTimeBetweenEvictionRunsMillis(30000);
            //表示idle object evitor每次扫描的最多的对象数
            config.setNumTestsPerEvictionRun(10);
            //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
            config.setMinEvictableIdleTimeMillis(60000);
            if(StringUtils.isEmpty(jedisPassword)) {
                jedisPool = new JedisPool(config
                        , jedisIP
                        , jedisPort);//修改到线上配置
            }
            else
            {
                jedisPool = new JedisPool(config
                        , jedisIP
                        , jedisPort,60000,jedisPassword);//修改到线上配置
            }
        }
        return jedisPool;
    }

    private static final int JEDIS_QUEUE_DATABASE = 1;//redis 队列使用database索引
    private static final int JEDIS_CACHE_DATABASE = 2;//redis 缓存使用database索引

    @Value("${spring.redis.host}")
    private String jedisIP;

    @Value("${spring.redis.port}")
    private int jedisPort;

    @Value("${spring.redis.password}")
    private String jedisPassword;

    private static JedisPool jedisPool;

    //redis定阅channel 数据
    public static void subscribe(JedisPubSub jedisPubSub, String channel){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.subscribe(jedisPubSub,channel);
        }
    }
    //发布信息到channel
    public static void publish(String channel,Object object){
        try (Jedis jedis = jedisPool.getResource()){
            jedis.publish(channel,ObjectUtil.toJSON(object));
        }
    }


    /**
     * 获取数据
     * @param key
     * @return
     */
    public static String get(String key){
        String value=null;
        Jedis jedis=null;
        try{
            jedis=jedisPool.getResource();
            value=jedis.get(key);
        }catch (Exception e){
            jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        }finally {
            close(jedis);
        }
        return value;
    }

    private static void close(Jedis jedis) {
        try{
            jedisPool.returnResource(jedis);
        }catch (Exception e){
            if(jedis.isConnected()){
                jedis.quit();
                jedis.disconnect();
            }
        }
    }
    public static byte[] get(byte[] key){
        byte[] value = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }

        return value;
    }
    //重载设置缓存方法
    public static void set(String key,String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    public static void set(byte[] key, byte[] value) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    public static void set(byte[] key, byte[] value, int time) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
            jedis.expire(key, time);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    public static void hset(byte[] key, byte[] field, byte[] value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(key, field, value);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    public static void hset(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(key, field, value);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    public static String hget(String key, String field) {

        String value = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.hget(key, field);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }

        return value;
    }
    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    public static byte[] hget(byte[] key, byte[] field) {

        byte[] value = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.hget(key, field);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }

        return value;
    }
    //清理缓存值
    public static void hdel(String key,String field){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hdel(key, field);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    public static void hdel(byte[] key, byte[] field) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hdel(key, field);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }
    //用户字符串的入队
    public static void lpush(String key,String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.lpush(key, value);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    /**
     * 存储REDIS队列 顺序存储
     * @param  key reids键名
     * @param  value 键值
     */
    public static void lpush(byte[] key, byte[] value) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.lpush(key, value);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    /**
     * 存储REDIS队列 反向存储
     * @param  key reids键名
     * @param  value 键值
     */
    public static void rpush(byte[] key, byte[] value) {

        Jedis jedis = null;
        try {

            jedis = jedisPool.getResource();
            jedis.rpush(key, value);

        } catch (Exception e) {

            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {

            //返还到连接池
            close(jedis);

        }
    }

    /**
     * 将列表 source 中的最后一个元素(尾元素)弹出，并返回给客户端
     * @param  key reids键名
     * @param  destination 键值
     */
    public static void rpoplpush(byte[] key, byte[] destination) {

        Jedis jedis = null;
        try {

            jedis = jedisPool.getResource();
            jedis.rpoplpush(key, destination);

        } catch (Exception e) {

            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {

            //返还到连接池
            close(jedis);

        }
    }

    /**
     * 获取队列数据
     * @param  key 键名
     * @return
     */
    public static List lpopList(byte[] key) {

        List list = null;
        Jedis jedis = null;
        try {

            jedis = jedisPool.getResource();
            list = jedis.lrange(key, 0, -1);

        } catch (Exception e) {

            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {

            //返还到连接池
            close(jedis);

        }
        return list;
    }
    //字符串型的队列出队
    public static String rpop(String key){
        Jedis jedis = null;
        String value = null;
        try {

            jedis = jedisPool.getResource();
            value = jedis.rpop(key);

        } catch (Exception e) {

            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {

            //返还到连接池
            close(jedis);

        }
        return value;

    }

    /**
     * 获取队列数据
     * @param  key 键名
     * @return
     */
    public static byte[] rpop(byte[] key) {

        byte[] bytes = null;
        Jedis jedis = null;
        try {

            jedis = jedisPool.getResource();
            bytes = jedis.rpop(key);

        } catch (Exception e) {

            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {

            //返还到连接池
            close(jedis);

        }
        return bytes;
    }
    public static void hmset(Object key, Map hash) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.hmset(key.toString(), hash);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);

        }
    }
    public static void hmset(Object key, Map hash, int time) {
        Jedis jedis = null;
        try {

            jedis = jedisPool.getResource();
            jedis.hmset(key.toString(), hash);
            jedis.expire(key.toString(), time);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);

        }
    }
    public static List hmget(Object key, String... fields) {
        List result = null;
        Jedis jedis = null;
        try {

            jedis = jedisPool.getResource();
            result = jedis.hmget(key.toString(), fields);

        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);

        }
        return result;
    }

    public static Set hkeys(String key) {
        Set result = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.hkeys(key);

        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);

        }
        return result;
    }
    public static List lrange(byte[] key, int from, int to) {
        List result = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.lrange(key, from, to);

        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);

        }
        return result;
    }
    public static Map hgetAll(byte[] key) {
        Map result = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.hgetAll(key);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            //返还到连接池
            close(jedis);
        }
        return result;
    }

    public static void del(byte[] key) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
    }

    public static long llen(byte[] key) {

        long len = 0;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.llen(key);
        } catch (Exception e) {
            //释放redis对象
            //jedisPool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //返还到连接池
            close(jedis);
        }
        return len;
    }
}
