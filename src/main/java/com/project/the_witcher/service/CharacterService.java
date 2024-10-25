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

    public CharacterDTO findCharacterByName(String name) {
        return convertCharacterToDTO(characterRepository.findByNameContainingIgnoreCase(name));
    }

    public List<CharacterDTO> findAllCharacters() {
        return characterRepository.findAll().stream().map(this::convertCharacterToDTO).collect(Collectors.toList());
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

    public List<CharacterDTO> convertCharactersToDTO(List<Character> characters) {
        return characters.stream()
                .map(this::convertCharacterToDTO)
                .collect(Collectors.toList());
    }
}
