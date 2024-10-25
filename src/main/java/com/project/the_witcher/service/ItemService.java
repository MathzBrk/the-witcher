package com.project.the_witcher.service;

import com.project.the_witcher.dto.ItemDTO;
import com.project.the_witcher.dto.MonsterDTO;
import com.project.the_witcher.model.Item;
import com.project.the_witcher.model.ItemRarity;
import com.project.the_witcher.model.ItemType;
import com.project.the_witcher.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<ItemDTO> getAllItems(){
       return convertToDTOs(itemRepository.findAll());
    }

    public List<ItemDTO> convertToDTOs(List<Item> items){
        return items.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ItemDTO convertToDTO(Item item){
        List<MonsterDTO> monsterDTOList = MonsterService.convertMonstersToMonsterDTO(item.getMonsterThatDrop());
        return new ItemDTO(item.getName(),item.getDescription(),item.getLocation(),item.getValue(),item.getType(),item.getRarity(),monsterDTOList);
    }

    public List<ItemDTO> findByRarity(String rarity) {
        ItemRarity itemRarity= ItemRarity.fromString(rarity);
        return convertToDTOs(itemRepository.findByRarity(itemRarity));
    }

    public List<ItemDTO> findByType(String type) {
        ItemType itemType = ItemType.fromString(type);
       return convertToDTOs(itemRepository.findByType(itemType));
    }
}
