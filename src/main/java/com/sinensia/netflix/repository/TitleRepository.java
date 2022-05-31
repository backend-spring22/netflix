package com.sinensia.netflix.repository;

import com.sinensia.netflix.entity.Title;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title, Integer> {
    @RestResource(path="best",rel="bestTitles")
    @Query("select t from Title t order by t.user_rating desc, t.num_ratings desc")
    List<Title> findBest(Pageable pageable);
}
