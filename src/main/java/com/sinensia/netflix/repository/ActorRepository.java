package com.sinensia.netflix.repository;

import com.sinensia.netflix.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
