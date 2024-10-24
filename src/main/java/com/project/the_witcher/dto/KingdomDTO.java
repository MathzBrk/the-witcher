package com.project.the_witcher.dto;

import java.util.List;

public record KingdomDTO(
        String name,
        String description,
        List<String> allies,
        List<String> enemies
) {
}
