package com.wrp.wu.common.result;

import java.time.Instant;

/**
 * @author wrp
 * @date 2024年05月06日 22:36
 * @description
 */
public class RUtils {

    public static <T> R<T> success() {
        return success(null);
    }

    public static <T> R<T> success(T data) {
        return getInstance(REnum.SUCCESS.getCode(),
                REnum.SUCCESS.getMsg(), data);
    }

    public static <T> R<T> error() {
        return error(REnum.SUCCESS.getMsg());
    }

    public static <T> R<T> error(String msg) {
        return error(REnum.SERVER_ERROR.getCode(), msg);
    }

    public static <T> R<T> error(int code, String msg) {
        return getInstance(code, msg, null);
    }

    public static <T> R<T> getInstance(int code, String msg, T data) {
        return (R<T>) R.builder()
                .code(code)
                .msg(msg)
                .data(data)
                .timestamp(Instant.now().getNano())
                .build();
    }
}
