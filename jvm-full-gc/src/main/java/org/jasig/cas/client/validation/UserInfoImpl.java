//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.jasig.cas.client.validation;

public final class UserInfoImpl implements UserInfo {
    private static final long serialVersionUID = 410975846094569578L;
    private final String userId;
    private final String userAcct;
    private final String userName;
    private final String userOrg;
    private final String resourceJson;
    private final String userMobile;
    private final String userIdNo;
    private final String userOrgName;
    private final String userAreaCode;
    private final String userAreaName;

    public UserInfoImpl(String userId, String userAcct, String userName, String userOrg, String resourceJson, String userMObile, String userIdNo, String userOrgName, String userAreaCode, String userAreaName) {
        this.userId = userId;
        this.userAcct = userAcct;
        this.userName = userName;
        this.userOrg = userOrg;
        this.resourceJson = resourceJson;
        this.userMobile = userMObile;
        this.userIdNo = userIdNo;
        this.userOrgName = userOrgName;
        this.userAreaCode = userAreaCode;
        this.userAreaName = userAreaName;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserAcct() {
        return this.userAcct;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserOrg() {
        return this.userOrg;
    }

    public String getResourceJson() {
        return this.resourceJson;
    }

    public String getUserMobile() {
        return this.userMobile;
    }

    public String getUserIdNo() {
        return this.userIdNo;
    }

    public String getUserOrgName() {
        return this.userOrgName;
    }

    public String getUserAreaCode() {
        return this.userAreaCode;
    }

    public String getUserAreaName() {
        return this.userAreaName;
    }
}
