package com.project.the_witcher.model;

public enum ItemRarity {
    COMMON,
    UNCOMMON,
    RARE,
    EPIC,
    LEGENDARY;

    public static ItemRarity fromString(String string) {
        for(ItemRarity rarity : ItemRarity.values()){
            if(rarity.name().equalsIgnoreCase(string)){
                return rarity;
            }
        }throw new IllegalArgumentException("Invalid item rarity: " + string);
    }
}
