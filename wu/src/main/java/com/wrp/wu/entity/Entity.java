package com.wrp.wu.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.Instant;

/**
 * @author wrp
 * @date 2024年05月06日 22:28
 * @description
 */
@Data
public class Entity {
    @TableId(type = IdType.ASSIGN_ID)
    protected Long id;
    @TableField(fill = FieldFill.INSERT)
    protected Instant createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected Instant updateTime;
    @TableLogic
    protected Boolean deleted;
}
