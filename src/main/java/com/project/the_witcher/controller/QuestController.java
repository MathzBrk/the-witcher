package com.project.the_witcher.controller;

import com.project.the_witcher.dto.QuestDTO;
import com.project.the_witcher.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quests")
public class QuestController {
    @Autowired
    private QuestService questService;

    @GetMapping
    public List<QuestDTO> getAllQuests() {
        return questService.getAllQuests();
    }

    @GetMapping("/title/{title}")
    public QuestDTO getQuestsByTitle(@PathVariable String title) {
        return questService.getQuestByTitle(title);
    }

    @GetMapping("/name/{characterName}")
    public List<QuestDTO> getQuestsByCharacter(@PathVariable String characterName) {
        return questService.getQuestsByCharacterName(characterName);
    }
}
