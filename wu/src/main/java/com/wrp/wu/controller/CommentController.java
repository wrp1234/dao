package com.wrp.wu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wrp.wu.common.result.R;
import com.wrp.wu.common.result.RUtils;
import com.wrp.wu.controller.support.CommentTo;
import com.wrp.wu.entity.Comment;
import com.wrp.wu.enums.OperationType;
import com.wrp.wu.enums.SortedField;
import com.wrp.wu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wrp
 * @date 2024年05月26日 9:31
 * @description
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping()
    public R add(@RequestBody CommentTo commentTo) {
        commentService.add(commentTo);
        return RUtils.success();
    }

    // 获取某文章评论的评论
    @GetMapping("/{articleId}")
    public R list(@PathVariable("articleId") Long articleId,
                     @RequestParam(value = "parentId", required = false) Long parentId,
                     @RequestParam(value = "pageNo", required = false, defaultValue = "1") Long pageNo,
                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Long pageSize,
                     @RequestParam(value = "sorted", required = false, defaultValue = "UPDATE_TIME")SortedField sortedField) {
        IPage<Comment> page = commentService.list(articleId, parentId, pageNo, pageSize, sortedField);
        return RUtils.success(page);
    }

    @GetMapping("/{id}/{operationType}")
    public R operate(@PathVariable("operationType") OperationType operationType,
                     @PathVariable("id") Long id
    ) {
        commentService.operate(id, operationType);
        return RUtils.success();
    }
}
