package com.sinensia.netflix.repository;

import com.sinensia.netflix.entity.Category;
import com.sinensia.netflix.entity.Title;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "categories", itemResourceRel = "category")
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @RestResource(path = "best", rel = "bestTitlesInCategory")
    @Query("select t from Title t inner join t.category c where c.id=?1 order by t.user_rating desc, t.num_ratings desc")
    List<Title> findBestInCategory(Integer id, Pageable pageable);
}
