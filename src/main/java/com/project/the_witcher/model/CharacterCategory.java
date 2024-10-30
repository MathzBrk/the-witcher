package com.project.the_witcher.model;

public enum CharacterCategory {
    BARD("Musician and storyteller"),
    COMMONER("Regular citizen without special status"),
    HEALER("Character with healing abilities"),
    KING("King of a Kingdom"),
    MERCHANT("Trader of goods"),
    SOLDIER("Member of the military"),
    SORCERESS("Female magic user"),
    DWARF("A person smaller than others"),
    WITCHER("Monster hunter with special abilities");

    private final String description;

    CharacterCategory( String description ) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static CharacterCategory fromString( String category ) {
        for (CharacterCategory characterCategory : CharacterCategory.values()) {
            if (characterCategory.name().equalsIgnoreCase(category)) {
                return characterCategory;
            }
        }
        throw new IllegalArgumentException("Invalid category: " + category);
    }
}
