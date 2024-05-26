package com.wrp.wu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wrp
 * @date 2024年05月06日 22:30
 * @description
 */
@Data
@TableName(value = "article", autoResultMap = true)
public class Article extends Entity {
    private String title;
    private Long userId;
    private String content;
    private int sorted;
    private long likes;
    private long hates;
    // 收藏
    private long collections;
    // 转发
    private long forwards;
    // 浏览量
    private long hits;

    public void incrLikes() {
        this.likes++;
    }

    public void incrHates() {
        this.hates++;
    }

    public void incrCollections() {
        this.collections++;
    }

    public void incrForwards() {
        this.forwards++;
    }

    public void incrHits() {
        this.hits++;
    }
}
