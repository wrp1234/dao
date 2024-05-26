package com.wrp.wu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wrp.wu.controller.support.CommentTo;
import com.wrp.wu.entity.Comment;
import com.wrp.wu.enums.OperationType;
import com.wrp.wu.enums.SortedField;

/**
 * @author wrp
 * @date 2024年05月26日 9:30
 * @description
 */
public interface CommentService extends IService<Comment> {
    void delByArticleId(Long articleId);

    void add(CommentTo commentTo);

    IPage<Comment> list(Long articleId, Long parentId, Long pageNo, Long pageSize, SortedField sortedField);

    void operate(Long id, OperationType operationType);
}
