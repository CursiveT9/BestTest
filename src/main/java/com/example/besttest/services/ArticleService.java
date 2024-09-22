package com.example.besttest.services;

import com.example.besttest.dtos.ArticleDTO;
import jakarta.transaction.Transactional;
import java.util.List;

public interface ArticleService {
    ArticleDTO createArticle(ArticleDTO articleDTO);
    List<ArticleDTO> getAllArticles();
    void deleteArticle(String articleId);
    ArticleDTO getArticleDTOById(String id);
    @Transactional
    ArticleDTO editArticle(String id, ArticleDTO articleDTO);
}
