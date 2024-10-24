package com.project.the_witcher.dto;

import com.project.the_witcher.model.MonsterCategory;

public record MonsterDTO(
        String name,
        MonsterCategory category,
        String description
) {
}
