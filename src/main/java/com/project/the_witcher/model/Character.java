package com.project.the_witcher.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;

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

    private CharacterCategory category;
    private String background;

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

    @ManyToMany
    private List<Quest> questsInvolved;

    public Character() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
