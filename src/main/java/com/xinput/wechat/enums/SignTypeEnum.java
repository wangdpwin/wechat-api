package com.xinput.wechat.enums;

import com.xinput.bleach.util.StringUtils;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-09-18 11:47
 */
public enum SignTypeEnum {

    /**
     * MD5签名，默认
     */
    MD5("MD5"),

    /**
     * HMAC-SHA256签名
     */
    HMAC("HMAC-SHA256");

    private String type;

    SignTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static SignTypeEnum getSignType(String signType) {
        if (StringUtils.isNullOrEmpty(signType)) {
            return null;
        }

        for (SignTypeEnum signTypeEnum : SignTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(signTypeEnum.getType(), signType)) {
                return signTypeEnum;
            }
        }

        return null;
    }

    /**
     * 获取有效的验证算法名称
     *
     * @param signType
     * @return
     */
    public static String getAllowSign(String signType) {
        SignTypeEnum signTypeEnum = getSignType(signType);
        if (signType == null) {
            return MD5.getType();
        }

        return signTypeEnum.getType();
    }

}
