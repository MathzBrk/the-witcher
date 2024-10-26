package com.project.the_witcher;

import com.project.the_witcher.model.*;
import com.project.the_witcher.model.Character;
import com.project.the_witcher.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private KingdomRepository kingdomRepository;

    @Autowired
    private QuestRepository questRepository;

    @Override
    public void run( String... args ) throws Exception {

        characterRepository.deleteAll();
        kingdomRepository.deleteAll();
        monsterRepository.deleteAll();
        itemRepository.deleteAll();
        questRepository.deleteAll();

        Character geralt = new Character("Geralt of Rivia", "Male", CharacterCategory.WITCHER, "A monster hunter from the School of the Wolf");
        Character yennefer = new Character("Yennefer of Vengerberg", "Female", CharacterCategory.SORCERESS, "A powerful sorceress with a complex past");
        Character ciri = new Character("Ciri", "Female", CharacterCategory.WITCHER, "A young girl with a mysterious destiny");
        characterRepository.saveAll(Arrays.asList(geralt, yennefer, ciri));

        Kingdom temeria = new Kingdom("Temeria", "A northern kingdom, known for its strength and stability.",
                Collections.singletonList("Redania"),
                Collections.singletonList("Nilfgaard"));
        Kingdom nilfgaard = new Kingdom("Nilfgaard", "An empire to the south, known for its ambition and military might.",
                Collections.singletonList("Temeria"),
                Collections.singletonList("Redania"));
        Kingdom redania = new Kingdom("Redania", "A powerful kingdom known for its political intrigue.",
                Collections.singletonList("Temeria"),
                Collections.singletonList("Nilfgaard"));
        kingdomRepository.saveAll(Arrays.asList(temeria, nilfgaard, redania));

        // Carregar monstros
        Monster griffin = new Monster("Griffin", MonsterCategory.BEAST, "A large creature with the body of a lion and the head of an eagle.");
        Monster basilisk = new Monster("Basilisk", MonsterCategory.REPTILE, "A monstrous reptile with deadly gaze.");
        Monster wraith = new Monster("Wraith", MonsterCategory.SPECTER, "A restless spirit of the dead.");
        monsterRepository.saveAll(Arrays.asList(griffin, basilisk, wraith));

        // Carregar itens com listas de monstros que os soltam
        Item steelSword = new Item("Steel Sword", "A sturdy sword used to slay monsters.", "Kaer Morhen", 500.00,
                ItemType.WEAPON, ItemRarity.RARE, Collections.singletonList(griffin));
        Item healthPotion = new Item("Health Potion", "A potion that restores health.", "Various", 50.00,
                ItemType.CONSUMABLE, ItemRarity.COMMON, Collections.emptyList());
        Item dimeritiumBomb = new Item("Dimeritium Bomb", "A bomb that is effective against magical creatures.", "Skellige", 300.00,
                ItemType.WEAPON, ItemRarity.EPIC, Collections.singletonList(wraith));
        itemRepository.saveAll(Arrays.asList(steelSword, healthPotion, dimeritiumBomb));

        // Carregar quests com listas de personagens
        Quest quest1 = new Quest("The Beast of Toussaint", "Investigate the mysterious beast terrorizing the countryside.",
                Collections.singletonList(geralt));
        Quest quest2 = new Quest("A Deadly Surprise", "A routine mission turns into a deadly surprise.",
                Arrays.asList(geralt, ciri));
        Quest quest3 = new Quest("Family Matters", "Find out what happened to Ciri’s family.",
                Collections.singletonList(yennefer));
        questRepository.saveAll(Arrays.asList(quest1, quest2, quest3));

        // Atribuir personagens às quests
        geralt.getQuestsInvolved().addAll(Arrays.asList(quest1, quest2));
        yennefer.getQuestsInvolved().add(quest3);
        ciri.getQuestsInvolved().add(quest2);

        // Persistir os personagens novamente para que as mudanças nas quests sejam salvas
        characterRepository.saveAll(Arrays.asList(geralt, yennefer, ciri));
    }
}
