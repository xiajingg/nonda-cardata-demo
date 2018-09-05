package nonda.cardata.dcom;

import redis.clients.jedis.JedisPubSub;

//订阅分发队列 基于redis（用于一次发布，多次消费） by tom
public class EPubsub {

    public static void sub(String channel, JedisPubSub jedisPubSub)
    {
        JedisUtil.subscribe(jedisPubSub,channel);
    }
    public static void pub(String channel,Object object)
    {
        JedisUtil.publish(channel,object);
    }
}
