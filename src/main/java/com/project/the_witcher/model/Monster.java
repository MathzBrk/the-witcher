package com.project.the_witcher.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Monster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MonsterCategory category;
    private String description;
    @ManyToMany(mappedBy = "monsterThatDrop")
    private List<Item> possibleDrops;


    public Monster(String name, MonsterCategory category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Monster(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonsterCategory getCategory() {
        return category;
    }

    public void setCategory(MonsterCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getPossibleDrops() {
        return possibleDrops;
    }

    public void setPossibleDrops(List<Item> possibleDrops) {
        this.possibleDrops = possibleDrops;
    }
}
