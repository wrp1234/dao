package com.wrp.wu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrp.wu.controller.CommentController;
import com.wrp.wu.controller.support.ArticleQuery;
import com.wrp.wu.controller.support.ArticleTo;
import com.wrp.wu.enums.OperationType;
import com.wrp.wu.service.ArticleService;
import com.wrp.wu.entity.Article;
import com.wrp.wu.mapper.ArticleMapper;
import com.wrp.wu.service.CommentService;
import com.wrp.wu.vo.ArticleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wrp
 * @date 2024年05月06日 22:33
 * @description
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {

    @Autowired
    private CommentService commentService;

    @Override
    public Long add(ArticleTo article) {
        Article articleEntity = new Article();
        BeanUtils.copyProperties(article, articleEntity);
        save(articleEntity);
        return articleEntity.getId();
    }

    @Override
    public Page<ArticleVo> list(ArticleQuery articleQuery) {
        Page<Article> page = new Page(articleQuery.getPageNo(), articleQuery.getPageSize());
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        switch (articleQuery.getSortedBy()) {
            case UPDATE_TIME -> wrapper.orderByDesc(Article::getCreateTime);
            case LIKES -> wrapper.orderByDesc(Article::getLikes);
        }

        if(StringUtils.hasText(articleQuery.getValue())) {
            wrapper.like(Article::getTitle, articleQuery.getValue())
                    .or().like(Article::getTitle, articleQuery.getValue());
        }
        page(page, wrapper);
        Page<ArticleVo> resultPage = new Page();
        BeanUtils.copyProperties(page, resultPage);
        resultPage.setRecords(page.getRecords().stream().map(e-> {
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(e, articleVo);
            return articleVo;
        }).toList());
        return resultPage;
    }

    @Override
    public Article get(Long id) {
        Article article = getById(id);
        if(article != null) {
            article.incrHits();
            updateById(article);
        }
        return article;
    }

    @Override
    public void operate(Long id, OperationType operationType) {
        Article article = getById(id);
        if(article != null) {
            switch (operationType) {
                case LIKE -> article.incrLikes();
                case HATE -> article.incrHates();
                case COLLECTION -> article.incrCollections();
                case FORWARD -> article.incrForwards();
            }
            updateById(article);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void del(Long id) {
        Article article = getById(id);
        if(article != null) {
            // 删除评论
            commentService.delByArticleId(article.getId());
            removeById(id);
        }
    }
}
