package com.project.the_witcher.dto;

import com.project.the_witcher.model.CharacterCategory;
import com.project.the_witcher.model.Quest;
import java.util.List;

public record CharacterDTO(
        String name,
        String gender,
        CharacterCategory category,
        String background,
        List<Quest> questsInvolved
) {
}
