package com.wrp.wu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrp.wu.controller.support.CommentTo;
import com.wrp.wu.entity.Comment;
import com.wrp.wu.enums.OperationType;
import com.wrp.wu.enums.SortedField;
import com.wrp.wu.mapper.CommentMapper;
import com.wrp.wu.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wrp
 * @date 2024年05月26日 9:31
 * @description
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {
    @Override
    public void delByArticleId(Long articleId) {
        List<Comment> comments = list(new LambdaQueryWrapper<Comment>()
                .eq(Comment::getArticleId, articleId));
        removeBatchByIds(comments.stream().map(c->c.getId()).toList());
    }

    @Override
    public void add(CommentTo commentTo) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentTo, comment);
        save(comment);
    }

    @Override
    public IPage<Comment> list(Long articleId, Long parentId, Long pageNo, Long pageSize, SortedField sortedField) {
        IPage<Comment> page = new Page<>(pageNo, pageSize);
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<Comment>()
                .eq(Comment::getArticleId, articleId);
        switch (sortedField) {
            case UPDATE_TIME -> wrapper.orderByDesc(Comment::getUpdateTime);
            case LIKES -> wrapper.orderByDesc(Comment::getLikes);
        }

        if(parentId != null) {
            wrapper.eq(Comment::getParentId, parentId);
        }

        list(page, wrapper);
        // 查询子评论的数量
        List<Comment> subLists = list(new LambdaQueryWrapper<Comment>()
                .in(Comment::getParentId, page.getRecords().stream().map(c -> c.getId()).toList()));
        page.getRecords().forEach(c-> {
            c.setSubNums(subLists.stream()
                    .filter(c2->!c2.getParentId().equals(c.getId()))
                    .count());
        });

        return page;
    }

    @Override
    public void operate(Long id, OperationType operationType) {
        Comment comment = getById(id);

        if(comment != null) {
            switch (operationType) {
                case LIKE -> comment.incrLikes();
                case HATE -> comment.incrHates();
            }
        }
    }
}
