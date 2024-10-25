package com.project.the_witcher.controller;

import com.project.the_witcher.dto.ItemDTO;
import com.project.the_witcher.model.Item;
import com.project.the_witcher.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/rarity/{rarity}")
    public List<ItemDTO> getByRarity(@PathVariable String rarity) {
        return itemService.findByRarity(rarity);
    }

    @GetMapping("/type/{type}")
    public List<ItemDTO> getByType(@PathVariable String type) {
        return itemService.findByType(type);
    }
}
