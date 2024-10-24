package com.project.the_witcher;

import com.project.the_witcher.model.*;
import com.project.the_witcher.model.Character;
import com.project.the_witcher.repository.CharacterRepository;
import com.project.the_witcher.repository.ItemRepository;
import com.project.the_witcher.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private MonsterRepository monsterRepository;
    @Autowired CharacterRepository characterRepository;

    @Override
    public void run(String... args) throws Exception {

        itemRepository.deleteAll();
        monsterRepository.deleteAll();
        characterRepository.deleteAll();
    }
}
