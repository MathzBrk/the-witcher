package com.project.the_witcher.service;

import com.project.the_witcher.dto.MonsterDTO;
import com.project.the_witcher.model.Monster;
import com.project.the_witcher.repository.MonsterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    public List<MonsterDTO> getAllMonsters() {
        return convertMonstersToMonsterDTO(monsterRepository.findAll());
    }

    public MonsterDTO findMonsterByName(String name) {
        Optional<Monster> monster = monsterRepository.findByNameContainingIgnoreCase(name);
        if (monster.isPresent())
            return convertMonsterToMonsterDTO(monster.get());
        else
           return null;

    }


    public MonsterDTO convertMonsterToMonsterDTO(Monster monster) {
        return new MonsterDTO(monster.getName(), monster.getCategory(), monster.getDescription());
    }

    public static List<MonsterDTO> convertMonstersToMonsterDTO(List<Monster> monsterList) {
        return monsterList.stream()
                .map(m -> new MonsterDTO(m.getName(),m.getCategory(),m.getDescription()))
                .collect(Collectors.toList());
    }


}
