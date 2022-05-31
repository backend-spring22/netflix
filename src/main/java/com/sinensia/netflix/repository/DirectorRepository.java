package com.sinensia.netflix.repository;

import com.sinensia.netflix.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Integer> {
}
