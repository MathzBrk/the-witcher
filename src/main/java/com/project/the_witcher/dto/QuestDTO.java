package com.project.the_witcher.dto;

import com.project.the_witcher.model.Character;
import java.util.List;

public record QuestDTO(
        String title,
        String description,
        List<Character> characters
) {}
