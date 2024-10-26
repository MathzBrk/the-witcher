package com.project.the_witcher.model;

public enum MonsterCategory {
    ABERRATION,
    BEAST,
    UNDEAD,
    DEMON,
    HUMAN,
    REPTILE,
    SPECTER,
    DRAGON;

    public static MonsterCategory fromString(String category) {
        for(MonsterCategory mc : MonsterCategory.values()) {
            if(mc.name().equalsIgnoreCase(category)) {
                return mc;
            }
        }
        throw new IllegalArgumentException("Invalid Category: " + category);
    }
}

