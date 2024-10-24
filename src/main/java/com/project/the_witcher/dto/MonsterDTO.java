package com.project.the_witcher.dto;

import com.project.the_witcher.model.MonsterCategory;
import java.util.List;

public record MonsterDTO(
        String name,
        MonsterCategory category,
        String description,
        List<ItemDTO> possibleDrops
) {
}
