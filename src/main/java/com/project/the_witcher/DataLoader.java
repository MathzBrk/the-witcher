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

        // Limpar os dados antigos
        characterRepository.deleteAll();
        kingdomRepository.deleteAll();
        monsterRepository.deleteAll();
        itemRepository.deleteAll();
        questRepository.deleteAll();


        Character geralt = new Character("Geralt of Rivia", "Male", CharacterCategory.WITCHER, "A monster hunter from the School of the Wolf");
        Character yennefer = new Character("Yennefer of Vengerberg", "Female", CharacterCategory.SORCERESS, "A powerful sorceress with a complex past");
        Character ciri = new Character("Ciri", "Female", CharacterCategory.WITCHER, "A young girl with a mysterious destiny");
        Character triss = new Character("Triss Merigold", "Female", CharacterCategory.SORCERESS, "A loyal friend and powerful sorceress who helps Geralt");
        Character dandelion = new Character("Dandelion", "Male", CharacterCategory.BARD, "A flamboyant bard and Geralt's best friend");
        Character emhyr = new Character("Emhyr var Emreis", "Male", CharacterCategory.KING, "The ruthless emperor of Nilfgaard");
        characterRepository.saveAll(Arrays.asList(geralt, yennefer, ciri, triss, dandelion, emhyr));


        Kingdom temeria = new Kingdom("Temeria", "A northern kingdom, known for its strength and stability.",
                Collections.singletonList("Redania"),
                Collections.singletonList("Nilfgaard"));
        Kingdom nilfgaard = new Kingdom("Nilfgaard", "An empire to the south, known for its ambition and military might.",
                Collections.singletonList("Temeria"),
                Collections.singletonList("Redania"));
        Kingdom redania = new Kingdom("Redania", "A powerful kingdom known for its political intrigue.",
                Collections.singletonList("Temeria"),
                Collections.singletonList("Nilfgaard"));
        Kingdom skellige = new Kingdom("Skellige", "A group of islands inhabited by fierce warriors and sailors.",
                Arrays.asList("Nilfgaard", "Temeria"),
                Collections.emptyList());
        Kingdom toussaint = new Kingdom("Toussaint", "A duchy known for its vineyards and chivalry.",
                Collections.singletonList("Nilfgaard"),
                Collections.emptyList());
        kingdomRepository.saveAll(Arrays.asList(temeria, nilfgaard, redania, skellige, toussaint));


        Monster griffin = new Monster("Griffin", MonsterCategory.BEAST, "A large creature with the body of a lion and the head of an eagle.");
        Monster basilisk = new Monster("Basilisk", MonsterCategory.REPTILE, "A monstrous reptile with deadly gaze.");
        Monster wraith = new Monster("Wraith", MonsterCategory.SPECTER, "A restless spirit of the dead.");
        Monster leshen = new Monster("Leshen", MonsterCategory.RELICT, "A forest spirit that can control animals and plants.");
        Monster drowners = new Monster("Drowners", MonsterCategory.NECROPHAGE, "Creatures that lurk in waters and attack the living.");
        Monster fiend = new Monster("Fiend", MonsterCategory.RELICT, "A large, horned beast that relies on brute strength.");
        monsterRepository.saveAll(Arrays.asList(griffin, basilisk, wraith, leshen, drowners, fiend));


        Item steelSword = new Item("Steel Sword", "A sturdy sword used to slay monsters.", "Kaer Morhen", 500.00,
                ItemType.WEAPON, ItemRarity.RARE, Collections.singletonList(griffin));
        Item healthPotion = new Item("Health Potion", "A potion that restores health.", "Various", 50.00,
                ItemType.CONSUMABLE, ItemRarity.COMMON, Collections.emptyList());
        Item dimeritiumBomb = new Item("Dimeritium Bomb", "A bomb that is effective against magical creatures.", "Skellige", 300.00,
                ItemType.WEAPON, ItemRarity.EPIC, Collections.singletonList(wraith));
        Item silverSword = new Item("Silver Sword", "A sword made of silver, specifically for hunting magical creatures.", "Kaer Morhen", 700.00,
                ItemType.WEAPON, ItemRarity.EPIC, Arrays.asList(leshen, wraith));
        Item swallow = new Item("Swallow Potion", "A potion that significantly accelerates health regeneration.", "Various", 100.00,
                ItemType.CONSUMABLE, ItemRarity.UNCOMMON, Collections.emptyList());
        itemRepository.saveAll(Arrays.asList(steelSword, healthPotion, dimeritiumBomb, silverSword, swallow));


        Quest quest1 = new Quest("The Beast of Toussaint", "Investigate the mysterious beast terrorizing the countryside.",
                Collections.singletonList(geralt));
        Quest quest2 = new Quest("A Deadly Surprise", "A routine mission turns into a deadly surprise.",
                Arrays.asList(geralt, ciri));
        Quest quest3 = new Quest("Family Matters", "Find out what happened to Ciri’s family.",
                Collections.singletonList(yennefer));
        Quest quest4 = new Quest("The Battle of Kaer Morhen", "Defend Kaer Morhen from the Wild Hunt.",
                Arrays.asList(geralt, ciri, triss, dandelion));
        Quest quest5 = new Quest("Emperor's Orders", "Meet Emperor Emhyr to discuss an important mission.",
                Collections.singletonList(emhyr));
        questRepository.saveAll(Arrays.asList(quest1, quest2, quest3, quest4, quest5));

        // Atribuir personagens às quests
        geralt.getQuestsInvolved().addAll(Arrays.asList(quest1, quest2, quest4));
        yennefer.getQuestsInvolved().add(quest3);
        ciri.getQuestsInvolved().addAll(Arrays.asList(quest2, quest4));
        triss.getQuestsInvolved().add(quest4);
        dandelion.getQuestsInvolved().add(quest4);
        emhyr.getQuestsInvolved().add(quest5);

        characterRepository.saveAll(Arrays.asList(geralt, yennefer, ciri, triss, dandelion, emhyr));
    }
}
