package com.wrp.wu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wrp.wu.controller.support.ArticleQuery;
import com.wrp.wu.controller.support.ArticleTo;
import com.wrp.wu.entity.Article;
import com.wrp.wu.enums.OperationType;
import com.wrp.wu.vo.ArticleVo;

import java.util.List;

/**
 * @author wrp
 * @date 2024年05月06日 22:33
 * @description
 */
public interface ArticleService extends IService<Article> {
    Long add(ArticleTo article);

    Page<ArticleVo> list(ArticleQuery articleQuery);

    Article get(Long id);

    void operate(Long id, OperationType operationType);

    void del(Long id);
}
