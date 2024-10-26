package com.project.the_witcher.service;

import com.project.the_witcher.dto.KingdomDTO;
import com.project.the_witcher.model.Kingdom;
import com.project.the_witcher.repository.KingdomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KingdomService {

    @Autowired
    KingdomRepository kingdomRepository;

    public KingdomDTO convertKingdomToKingdomDTO(Kingdom kingdom) {
        return new KingdomDTO(kingdom.getName(),kingdom.getDescription(),kingdom.getAllies(),kingdom.getEnemies());
    }

    public List<KingdomDTO> convertKingdomsToKingdomDTO(List<Kingdom> kingdoms) {
        return kingdoms.stream()
                .map(this::convertKingdomToKingdomDTO)
                .collect(Collectors.toList());
    }

    public List<KingdomDTO> getAllKingdoms() {
        return convertKingdomsToKingdomDTO(kingdomRepository.findAll());
    }

    public KingdomDTO getKingdomByName(String name) {
        return convertKingdomToKingdomDTO(kingdomRepository.findByNameContainingIgnoreCase(name));
    }
}
