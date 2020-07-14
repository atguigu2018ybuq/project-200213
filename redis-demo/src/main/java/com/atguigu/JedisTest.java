package com.atguigu;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class JedisTest {

    public static void main(String[] args) {

        //1.创建Redis客户端
        Jedis jedis = new Jedis("hadoop102", 6379);

        //2.ping一下
        String ping = jedis.ping();

        //Key
        jedis.exists("");
        jedis.move("", 0);
        jedis.select(5);
        jedis.rename("", "");
        jedis.renamenx("", "");
        jedis.ttl("");
        jedis.expire("", 10);
        jedis.persist("");

        //String
        jedis.set("", "");
        jedis.get("");
        jedis.incr("");
        jedis.incrBy("", 1L);
        jedis.append("", "");
        jedis.mset("", "", "", "");

        //List
        jedis.rpush("", "");

        //Map
        HashMap<String, String> objectHashMap = new HashMap<>();
        jedis.hmset("", objectHashMap);

        //3.打印ping
        System.out.println(ping);

        //4.关闭连接
        jedis.close();

    }

}
