package com.project.the_witcher.repository;

import com.project.the_witcher.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Long> {
    
}
