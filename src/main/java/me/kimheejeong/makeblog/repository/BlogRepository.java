package me.kimheejeong.makeblog.repository;

import me.kimheejeong.makeblog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
