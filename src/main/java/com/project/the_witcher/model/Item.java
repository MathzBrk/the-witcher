package com.project.the_witcher.model;

import jakarta.persistence.*;

import java.util.ArrayList;
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
    @Enumerated(EnumType.STRING)
    private ItemType type;
    @Enumerated(EnumType.STRING)
    private ItemRarity rarity;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "item_monster",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "monster_id")
    )
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
        if(value != null) {
            this.value = value;
        }else{
            this.value = 0.0;
        }
        this.type = type;
        this.rarity = rarity;
        this.monsterThatDrop = new ArrayList<>();
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

    public void addMonster(Monster monster) {
        if (!monsterThatDrop.contains(monster)) {
            monsterThatDrop.add(monster);
            monster.getPossibleDrops().add(this);
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", value=" + value +
                ", type=" + type +
                ", rarity=" + rarity +
                ", monsterThatDrop=" + monsterThatDrop +
                '}';
    }
}
