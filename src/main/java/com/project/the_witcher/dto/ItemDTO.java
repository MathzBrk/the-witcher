package com.project.the_witcher.dto;

import com.project.the_witcher.model.ItemRarity;
import com.project.the_witcher.model.ItemType;
import com.project.the_witcher.model.Monster;
import java.util.List;

public record ItemDTO(
        String name,
        String description,
        String location,
        Double value,
        ItemType type,
        ItemRarity rarity
) {
}
