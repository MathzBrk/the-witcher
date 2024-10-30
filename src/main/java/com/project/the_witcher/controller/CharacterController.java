package com.project.the_witcher.controller;

import com.project.the_witcher.dto.CharacterDTO;
import com.project.the_witcher.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/{name}")
    public CharacterDTO getCharacterByName(@PathVariable String name) {
        return characterService.findCharacterDTOByName(name);
    }

    @GetMapping
    public List<CharacterDTO> getAllCharacters() {
        return characterService.findAllCharactersDTO();
    }

}
