package com.project.the_witcher.service;

import com.project.the_witcher.dto.CharacterDTO;
import com.project.the_witcher.dto.QuestDTO;
import com.project.the_witcher.model.Quest;
import com.project.the_witcher.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestService {

    @Autowired
    private QuestRepository questRepository;

    public List<QuestDTO> getAllQuestsDTO() {
        return convertQuestsToQuestDTO(questRepository.findAll());
    }

    public List<Quest> getAllQuests() {
        return questRepository.findAll();
    }

    public QuestDTO getQuestDTOByTitle(String title) {
        return convertQuestToQuestDTO(questRepository.findByTitleContainingIgnoreCase(title));
    }


    public Quest getQuestByTitle(String title) {
        return questRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<QuestDTO> getQuestsByCharacterName(String characterName) {
        return convertQuestsToQuestDTO(questRepository.findByCharactersNameContainingIgnoreCase(characterName));
    }

    public QuestDTO convertQuestToQuestDTO(Quest quest) {
        List<CharacterDTO> characterDTO = CharacterService.convertCharactersToDTO(quest.getCharacters());
        return new QuestDTO(quest.getTitle(),quest.getDescription(),characterDTO);
    }

    public List<QuestDTO> convertQuestsToQuestDTO(List<Quest> quests) {
        return quests.stream()
                .map(this::convertQuestToQuestDTO)
                .collect(Collectors.toList());
    }

    public void save( Quest quest ) {
        questRepository.saveAndFlush(quest);
    }
}
