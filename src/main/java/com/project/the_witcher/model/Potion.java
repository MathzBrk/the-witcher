package com.project.the_witcher.model;

import java.util.List;

public class Potion extends Item {
    private String effect;

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Potion(String name, String description, String location, Double value, ItemType type, ItemRarity rarity, String effect, List<Monster> monsterThatDrop) {
        super(name, description, location, value, type, rarity, monsterThatDrop);
        this.effect = effect;
    }
}
