package com.project.the_witcher.model;

public enum ItemType {
    WEAPON,
    POTION,
    ARMOR,
    CONSUMABLE,
    MISC;

    public static ItemType fromString(String string) {
        for (ItemType itemType : ItemType.values()) {
            if(itemType.name().equalsIgnoreCase(string)) {
                return itemType;
            }
        } throw new IllegalArgumentException("Invalid item type: " + string);
    }
}
