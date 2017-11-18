package org.miaohong.fishchat.transport.common.url;

import org.miaohong.fishchat.transport.common.constant.Constants;

/**
 * @author miaohong
 * @date 2017/11/16
 */
public enum URLParamType {
    /**
     * version
     **/
    version("version", Constants.DEFAULT_VERSION),

    // 格式为protocol:port
    export("export", ""),
    embed("embed", ""),

    protocol("protocol", Constants.PROTOCOL_DEFAULT),
    path("path", ""),
    host("host", ""),
    port("port", 0);

    private String name;
    private String value;
    private long longValue;
    private int intValue;
    private boolean boolValue;

    URLParamType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    URLParamType(String name, long longValue) {
        this.name = name;
        this.value = String.valueOf(longValue);
        this.longValue = longValue;
    }

    URLParamType(String name, int intValue) {
        this.name = name;
        this.value = String.valueOf(intValue);
        this.intValue = intValue;
    }

    URLParamType(String name, boolean boolValue) {
        this.name = name;
        this.value = String.valueOf(boolValue);
        this.boolValue = boolValue;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public int getIntValue() {
        return intValue;
    }

    public long getLongValue() {
        return longValue;
    }

    public boolean getBooleanValue() {
        return boolValue;
    }

}
