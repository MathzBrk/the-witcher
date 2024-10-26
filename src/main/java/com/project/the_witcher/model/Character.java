package com.project.the_witcher.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    @Enumerated(EnumType.STRING)
    private CharacterCategory category;
    private String background;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "character_quest",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "quest_id")
    )
    private List<Quest> questsInvolved;

    public Character(String name, String gender, CharacterCategory category, String background) {
        this.name = name;
        this.gender = gender;
        this.category = category;
        this.background = background;
        this.questsInvolved = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", category=" + category +
                ", background='" + background + '\'' +
                ", questsInvolved=" + questsInvolved +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CharacterCategory getCategory() {
        return category;
    }

    public void setCategory(CharacterCategory category) {
        this.category = category;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<Quest> getQuestsInvolved() {
        return questsInvolved;
    }

    public void setQuestsInvolved(List<Quest> questsInvolved) {
        this.questsInvolved = questsInvolved;
    }


    public Character() {
        this.questsInvolved = new ArrayList<>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
