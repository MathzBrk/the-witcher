package com.project.the_witcher.controller;

import com.project.the_witcher.dto.KingdomDTO;
import com.project.the_witcher.service.KingdomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kingdoms")
public class KingdomController {

    @Autowired
    private KingdomService kingdomService;

    @GetMapping
    public List<KingdomDTO> getAllKingdoms() {
        return kingdomService.getAllKingdoms();
    }

    @GetMapping("/{name}")
    public KingdomDTO getKingdomByName(@PathVariable String name) {
        return kingdomService.getKingdomByName(name);
    }
}
