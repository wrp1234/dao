package com.wrp.wu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author wrp
 * @date 2024年05月26日 9:26
 * @description 评论
 */
@Data
@TableName(value = "comment", autoResultMap = true)
public class Comment extends Entity {
    private Long userId;
    private String nickName;
    private Long articleId;
    private Long parentId;
    private String content;
    private long likes;
    private long hates;

    @TableField(exist = false)
    private long subNums;

    public void incrLikes() {
        this.likes++;
    }

    public void incrHates() {
        this.hates++;
    }
}
