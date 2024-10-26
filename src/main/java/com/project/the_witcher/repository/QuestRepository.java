package com.project.the_witcher.repository;

import com.project.the_witcher.model.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestRepository extends JpaRepository<Quest, Long> {
    Quest findByTitleContainingIgnoreCase(String name);
    List<Quest> findByCharactersNameContainingIgnoreCase(String characterName);
}
