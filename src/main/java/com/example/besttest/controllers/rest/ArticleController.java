package com.example.besttest.controllers.rest;

import com.example.besttest.dtos.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.besttest.services.ArticleService;
import com.example.besttest.dtos.ArticleDTO;
import org.springframework.hateoas.Link;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {
        ArticleDTO createdArticle = articleService.createArticle(articleDTO);
        createdArticle = createLinks(createdArticle);
        return ResponseEntity.ok(createdArticle);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById (@PathVariable String id) {
        ArticleDTO articleDTO = articleService.getArticleDTOById(id);
        articleDTO = createLinks(articleDTO);
        return ResponseEntity.ok(articleDTO);
    }

    @GetMapping
    public List<ArticleDTO> getAllArticles() {
        List<ArticleDTO> articles = articleService.getAllArticles();
        return articles.stream()
                .peek(article -> {
                    article = createLinks(article);
                })
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable String id, @RequestBody ArticleDTO articleDTO) {
        ArticleDTO updatedArticle = articleService.editArticle(id, articleDTO);
        updatedArticle = createLinks(updatedArticle);
        return ResponseEntity.ok(updatedArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable String id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    private ArticleDTO createLinks(ArticleDTO articleDTO) {

        Link selfLink = linkTo(ArticleController.class).slash(articleDTO.getId()).withSelfRel();
        Link allArticlesLink = linkTo(ArticleController.class).withRel("allArticles");

        articleDTO.add(selfLink);
        articleDTO.add(allArticlesLink);

        String updateHref = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticleController.class).updateArticle(articleDTO.getId(), null)).toUri().toString();
        String deleteHref = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticleController.class).deleteArticle(articleDTO.getId())).toUri().toString();
        String createHref = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticleController.class).createArticle(articleDTO)).toUri().toString();

        articleDTO.addAction("update", new Action(updateHref, "PUT", "application/json"));
        articleDTO.addAction("delete", new Action(deleteHref, "DELETE"));
        articleDTO.addAction("create", new Action(createHref, "POST", "application/json"));

        return articleDTO;
    }

}
