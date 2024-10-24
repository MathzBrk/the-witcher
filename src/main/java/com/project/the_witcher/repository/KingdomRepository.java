package com.project.the_witcher.repository;

import com.project.the_witcher.model.Kingdom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KingdomRepository extends JpaRepository<Kingdom, Long> {
}
