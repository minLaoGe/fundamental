package com.minfengyu.day7;

import com.alibaba.fastjson.JSONObject;
import com.minfengyu.entity.User;

public class TestFastJson {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(3);
        user.setName("2dfs");
        user.setLegs("3");
        System.out.println(JSONObject.toJSONString(user));

    }
}
