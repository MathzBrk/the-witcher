package com.project.the_witcher.repository;

import com.project.the_witcher.dto.ItemDTO;
import com.project.the_witcher.model.Item;
import com.project.the_witcher.model.ItemRarity;
import com.project.the_witcher.model.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByRarity(ItemRarity rarity);

    List<Item> findByType(ItemType type);
}
