package com.wrp.wu.vo;

import lombok.Data;

import java.time.Instant;

/**
 * @author wrp
 * @date 2024年05月22日 7:57
 * @description
 */
@Data
public class ArticleVo {

    private Long id;
    private Instant createTime;
    private String title;
    private String summary;
    private String userName;
    private long hits;
}
