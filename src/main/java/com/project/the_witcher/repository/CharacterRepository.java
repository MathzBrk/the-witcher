package com.project.the_witcher.repository;

import com.project.the_witcher.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findByName(String name);
}
