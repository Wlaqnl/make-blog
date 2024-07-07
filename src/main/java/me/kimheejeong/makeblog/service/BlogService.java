package me.kimheejeong.makeblog.service;

import lombok.RequiredArgsConstructor;
import me.kimheejeong.makeblog.domain.Article;
import me.kimheejeong.makeblog.dto.AddArticleRequest;
import me.kimheejeong.makeblog.dto.UpdateArticleRequest;
import me.kimheejeong.makeblog.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    //블로그 글 목록 전체 조회
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    //블로그 글 상세 조회
    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //블로그 글 삭제
    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    //블로그 글 수정
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
