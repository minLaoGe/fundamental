package com.example.seckill.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;
import java.util.Set;

public class JedisUtil {
    private static Jedis jedis;
    private static JedisPool jedisPool = null;
    /**
     * 初始化Redis连接池
     */
    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jedisPool");
        if (bundle == null) {
            throw new IllegalArgumentException(
                    "[jedisPool.properties] is not found!");
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.valueOf(bundle
                .getString("redis.pool.maxTotal")));
        config.setMaxIdle(Integer.valueOf(bundle
                .getString("redis.pool.maxIdle")));
        config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWait")));
        config.setTestOnBorrow(Boolean.valueOf(bundle
                .getString("redis.pool.testOnBorrow")));
        config.setTestOnReturn(Boolean.valueOf(bundle
                .getString("redis.pool.testOnReturn")));
        jedisPool = new JedisPool(config, bundle.getString("redis.ip"),
                Integer.valueOf(bundle.getString("redis.port")));
        // 从池中获取一个Jedis对象
         jedis = jedisPool .getResource();
    }
    public void add(String sn) {
        jedis.sadd("snSet", sn);
        jedisPool.destroy();
    }
    public void remove(String sn) {
        jedis.srem("snSet", sn);
    }
    public boolean isExist(String sn) {
        Set<String> snSet = jedis.smembers("snSet");
        return snSet.contains(sn);
    }
    public static void main(String[] args) {
        String keys = "name";
// 删数据
        jedis.del(keys);
// 存数据
        jedis.set(keys, "snowolf");
// 取数据
        String value = jedis.get(keys);
        System.out.println(value);
// 释放对象池
//        jedisPool.returnResource(jedis);
    }
}