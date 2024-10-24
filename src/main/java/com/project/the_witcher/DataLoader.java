package com.project.the_witcher;

import com.project.the_witcher.model.Character;
import com.project.the_witcher.model.CharacterCategory;
import com.project.the_witcher.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public void run(String... args) throws Exception {

        // Criar dados de exemplo
        Character character1 = new Character("Geralt de Rivia", "Masculino", CharacterCategory.WITCHER, "Caçador de monstros");
        Character character2 = new Character("Yennefer", "Feminino", CharacterCategory.SORCERESS, "Maga poderosa");
        Character character3 = new Character("Ciri", "Feminino", CharacterCategory.WITCHER, "A filha de surpresa de Geralt");

        // Persistir os personagens no banco de dados
        characterRepository.saveAll(Arrays.asList(character1, character2, character3));
    }
}
