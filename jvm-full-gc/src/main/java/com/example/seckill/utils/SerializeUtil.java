//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.seckill.utils;

import com.example.seckill.entity.UserInfoImpl;
import redis.clients.jedis.Jedis;

import java.io.*;

public class SerializeUtil {
    public SerializeUtil() {
    }

    public static void main(String[] args) {
        Jedis jedis = null;
        String keys = "name";
        jedis.setex(keys, 60, "zy");
        String value = jedis.get(keys);
        System.out.println(value);
        UserInfoImpl p = new UserInfoImpl("1", "admin", "超级管理员", "机构Acode", "resjson", "13500010002", "330101199901265452", "机构A名称", "330101", "杭州市");
        jedis.setex("person".getBytes(), 60, serialize(p));
        byte[] byt = jedis.get("person".getBytes());
        Object obj = unserizlize(byt);
        if (obj instanceof UserInfoImpl) {
            System.out.println(obj);
        }

    }

    public static byte[] serialize(Object obj) {
        ObjectOutputStream obi = null;
        ByteArrayOutputStream bai = null;

        try {
            bai = new ByteArrayOutputStream();
            obi = new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt = bai.toByteArray();
            return byt;
        } catch (IOException var4) {
            var4.printStackTrace();
            return null;
        }
    }

    public static Object unserizlize(byte[] byt) {
        ObjectInputStream oii = null;
        ByteArrayInputStream bis = null;
        bis = new ByteArrayInputStream(byt);

        try {
            oii = new ObjectInputStream(bis);
            Object obj = oii.readObject();
            return obj;
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }
}
