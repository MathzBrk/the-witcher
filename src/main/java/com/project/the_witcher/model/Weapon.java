package com.project.the_witcher.model;

import java.util.List;

public class Weapon extends Item{

    private Integer damage;

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Weapon(String name, String description, String location, Double value, ItemType type, ItemRarity rarity, Integer damage, List<Monster> monsterThatDrop) {
        super(name, description, location, value, type, rarity, monsterThatDrop);
        this.damage = damage;
    }
}
