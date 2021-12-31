package org.jasig.cas.client.validation;

import java.io.Serializable;

public interface UserInfo extends Serializable {
    String getUserId();

    String getUserAcct();

    String getUserName();

    String getUserOrg();

    String getResourceJson();

    String getUserMobile();

    String getUserIdNo();

    String getUserOrgName();

    String getUserAreaCode();

    String getUserAreaName();
}
