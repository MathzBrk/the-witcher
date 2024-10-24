package com.project.the_witcher.dto;

import com.project.the_witcher.model.CharacterCategory;

public record CharacterDTO(
        String name,
        String gender,
        CharacterCategory category,
        String background
) {
}
