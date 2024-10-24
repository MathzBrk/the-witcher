package com.project.the_witcher.repository;

import com.project.the_witcher.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
