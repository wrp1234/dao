package com.wrp.wu.common.exception;

import com.wrp.wu.common.result.R;
import com.wrp.wu.common.result.REnum;
import com.wrp.wu.common.result.RUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wrp
 * @date 2024年05月06日 22:56
 * @description
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = BusinessException.class)
    public R bizExceptionHandler(BusinessException e) {
        return RUtils.error(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(Exception e) {
        log.error("全局异常", e.getMessage(), e);
        return RUtils.error(REnum.SERVER_ERROR.getMsg());
    }
}
