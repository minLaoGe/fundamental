package com.example.seckill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public  class UserInfoImpl implements Serializable {
    private static final long serialVersionUID = 410975846094569578L;
    private  String userId;
    private  String userAcct;
    private  String userName;
    private  String userOrg;
    private  String resourceJson;
    private  String userMobile;
    private  String userIdNo;
    private  String userOrgName;
    private  String userAreaCode;
    private  String userAreaName;

}
