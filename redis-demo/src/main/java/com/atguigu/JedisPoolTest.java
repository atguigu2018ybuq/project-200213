package com.atguigu;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolTest {

    public static void main(String[] args) {

        //1.创建Jedis连接池
        JedisPool jedisPool = new JedisPool("hadoop102", 6379);

        //2.从连接池中获取连接
        Jedis jedis = jedisPool.getResource();

        System.out.println("hotFix");

        //3.测试连接
        System.out.println(jedis.ping());

        //4.归还连接
        jedis.close();

    }

}
