package com.project.the_witcher.repository;

import com.project.the_witcher.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonsterRepository extends JpaRepository<Monster, Long> {

    Optional<Monster> findByNameContainingIgnoreCase(String name);
}
