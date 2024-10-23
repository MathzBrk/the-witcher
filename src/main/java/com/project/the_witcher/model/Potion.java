package com.project.the_witcher.model;

public class Potion extends Item {
    private String effect;

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Potion(String name, String description, String location, Double value, ItemType type, ItemRarity rarity, String effect) {
        super(name, description, location, value, type, rarity);
        this.effect = effect;
    }
}
