package com.project.the_witcher.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToMany(mappedBy = "questsInvolved", fetch = FetchType.EAGER)
    private List<Character> characters = new ArrayList<>();

    public Quest() {}

    public Quest(String title, String description, List<Character> characters) {
        this.title = title;
        this.description = description;
        this.characters = characters;
    }

    public void addCharacter(Character character) {
        if (!characters.contains(character)) {
            characters.add(character);
            character.getQuestsInvolved().add(this);
        }
    }


    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", characters=" + characters +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
