package com.wrp.wu.common.result;

/**
 * @author wrp
 * @date 2024年05月06日 22:38
 * @description
 */
public enum REnum {
    SUCCESS(200, "成功"),
    SERVER_ERROR(500, "服务器错误"),
    CLIENT_ERROR(400, "客户端错误")
    ;

    private int code;
    private String msg;

    REnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
