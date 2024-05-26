package com.wrp.wu.common.result;

import lombok.Builder;
import lombok.Data;

/**
 * @author wrp
 * @date 2024年05月06日 22:35
 * @description
 */
@Data
@Builder
public class R<T> {
    private int code;
    private String msg;
    private T data;
    private long timestamp;
}
