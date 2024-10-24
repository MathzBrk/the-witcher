package com.project.the_witcher.model;

public enum CharacterCategory {
    WITCHER("Monster hunter with special abilities"),
    SORCERESS("Female magic user"),
    HEALER("Character with healing abilities"),
    BARD("Musician and storyteller"),
    MERCHANT("Trader of goods"),
    SOLDIER("Member of the military"),
    COMMONER("Regular citizen without special status");

    private final String description;

    CharacterCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static CharacterCategory fromString(String category) {
        for (CharacterCategory characterCategory : CharacterCategory.values()) {
            if(characterCategory.name().equalsIgnoreCase(category)) {
                return characterCategory;
            }
        } throw new IllegalArgumentException("Invalid category: " + category);
    }
}
