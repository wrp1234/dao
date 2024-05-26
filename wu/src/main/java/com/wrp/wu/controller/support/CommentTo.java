package com.wrp.wu.controller.support;

import lombok.Data;

/**
 * @author wrp
 * @date 2024年05月26日 9:32
 * @description
 */
@Data
public class CommentTo {

    private Long articleId;
    private Long parentId;
    private String content;
}
