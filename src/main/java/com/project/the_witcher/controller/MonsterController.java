package com.project.the_witcher.controller;

import com.project.the_witcher.dto.MonsterDTO;
import com.project.the_witcher.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monsters")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping
    public List<MonsterDTO> getAllMonsters() {
        return monsterService.getAllMonstersDTO();
    }

    @GetMapping("/name/{name}")
    public MonsterDTO getMonsterByName(@PathVariable String name) {
        return monsterService.findMonsterByName(name);
    }



}
