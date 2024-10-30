package com.project.the_witcher.service;

import com.project.the_witcher.dto.CharacterDTO;
import com.project.the_witcher.model.Character;
import com.project.the_witcher.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public CharacterDTO findCharacterDTOByName(String name) {
        return convertCharacterToDTO(characterRepository.findByNameContainingIgnoreCase(name));
    }

    public Character findCharacterByName(String name) {
        return characterRepository.findByNameContainingIgnoreCase(name);
    }



    public List<Character> findAllCharacters() {
        return characterRepository.findAll();
    }

    public List<CharacterDTO> findAllCharactersDTO() {
        return characterRepository.findAll().stream().map(this::convertCharacterToDTO).collect(Collectors.toList());
    }

    public Character findCharacterById(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    public CharacterDTO convertCharacterToDTO(Character character) {
        if (character == null) {
            return null;
        }
        return new CharacterDTO(
                character.getName(),
                character.getGender(),
                character.getCategory(),
                character.getBackground()
        );
    }

    public static List<CharacterDTO> convertCharactersToDTO(List<Character> characters) {
        return characters.stream()
                .map(c -> new CharacterDTO(c.getName(),c.getGender(),c.getCategory(),c.getBackground()))
                .collect(Collectors.toList());
    }

    public void save( Character character ) {
        characterRepository.save(character);

    }

}
