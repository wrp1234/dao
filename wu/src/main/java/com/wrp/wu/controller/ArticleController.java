package com.wrp.wu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrp.wu.controller.support.ArticleQuery;
import com.wrp.wu.controller.support.ArticleTo;
import com.wrp.wu.entity.Article;
import com.wrp.wu.enums.OperationType;
import com.wrp.wu.service.ArticleService;
import com.wrp.wu.common.result.R;
import com.wrp.wu.common.result.RUtils;
import com.wrp.wu.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author wrp
 * @date 2024年05月06日 22:34
 * @description
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping()
    public R<Long> add(@RequestBody ArticleTo article) {
        Long articleId = articleService.add(article);
        return RUtils.success(articleId);
    }

    @PostMapping("list")
    public R<Page<ArticleVo>> list(@RequestBody @Validated ArticleQuery articleQuery) {
        Page<ArticleVo> page = articleService.list(articleQuery);
        return RUtils.success(page);
    }

    @GetMapping("/{id}")
    public R get(@PathVariable("id") Long id) {
        Article article = articleService.get(id);
        return RUtils.success(article);
    }

    @GetMapping("/{id}/{operationType}")
    public R operate(@PathVariable("operationType") OperationType operationType,
                       @PathVariable("id") Long id
                       ) {
        articleService.operate(id, operationType);
        return RUtils.success();
    }

    @DeleteMapping("{id}")
    public R del(@PathVariable("id") Long id) {
        articleService.del(id);
        return RUtils.success();
    }


}
