package com.project.the_witcher.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String description;
    private String location;
    private Double value;
    private ItemType type;
    private ItemRarity rarity;
    @ManyToMany(mappedBy = "possibleDrops")
    private List<Monster> monsterThatDrop;

    public List<Monster> getMonsterThatDrop() {
        return monsterThatDrop;
    }

    public void setMonsterThatDrop(List<Monster> monsterThatDrop) {
        this.monsterThatDrop = monsterThatDrop;
    }

    public Item(String name, String description, String location, Double value, ItemType type, ItemRarity rarity) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.value = value;
        this.type = type;
        this.rarity = rarity;
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public void setRarity(ItemRarity rarity) {
        this.rarity = rarity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
