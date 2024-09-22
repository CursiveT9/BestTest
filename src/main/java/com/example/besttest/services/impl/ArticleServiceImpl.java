package com.example.besttest.services.impl;

import com.example.besttest.dtos.ArticleDTO;
import com.example.besttest.dtos.TestingDTO;
import com.example.besttest.models.entities.Article;
import com.example.besttest.models.entities.Testing;
import com.example.besttest.repositories.ArticleRepository;
import com.example.besttest.services.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        return null;
    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(article -> modelMapper.map(article, ArticleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteArticle(String articleId) {
        articleRepository.deleteById(articleId);
    }

    @Override
    public ArticleDTO getArticleDTOById(String id) {
        Optional<Article> article = articleRepository.findById(id);
        return modelMapper.map(article, ArticleDTO.class);
    }

    @Override
    public ArticleDTO editArticle(String id, ArticleDTO articleDTO) {
        return null;
    }
}
