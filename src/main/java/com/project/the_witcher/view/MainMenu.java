package com.project.the_witcher.view;

import com.project.the_witcher.dto.KingdomDTO;
import com.project.the_witcher.model.*;
import com.project.the_witcher.model.Character;
import com.project.the_witcher.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;
import java.util.List;

@Component
public class MainMenu {

    private static final Scanner scanner = new Scanner(System.in);

    @Autowired
    private CharacterService characterService;
    @Autowired
    private MonsterService monsterService;
    @Autowired
    private QuestService questService;
    @Autowired
    private KingdomService kingdomService;
    @Autowired
    private ItemService itemService;


    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.start();
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            printMenu();


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCharacter();
                    break;
                case 2:
                    addMonster();
                    break;
                case 3:
                    viewCharacters();
                    break;
                case 4:
                    viewMonsters();
                    break;
                case 5:
                    viewQuests();
                    break;
                case 6:
                    addQuest();
                    break;
                case 7:
                    viewKingdoms();
                    break;
                case 8:
                    viewItems();
                    break;
                case 9:
                    addItem();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addItem() {
        try {
            System.out.println("Enter the name of the item: ");
            String name = scanner.nextLine();
            System.out.println("Enter the description of the item: ");
            String description = scanner.nextLine();
            System.out.println("Enter the location of the item: ");
            String location = scanner.nextLine();

            System.out.println("Enter the value of the item: ");
            String valueInput = scanner.nextLine().trim().replace(",", ".");
            Double value = Double.parseDouble(valueInput);

            System.out.println("Enter the type of the item: ");
            String type = scanner.nextLine();
            System.out.println("Enter the rarity of the item: ");
            String rarity = scanner.nextLine();

            Item item = new Item(name, description, location, value, ItemType.fromString(type), ItemRarity.fromString(rarity));
            itemService.save(item);

            System.out.println("Would you like to add a monster that drops this item? (Y/N)");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("Y")) {
                List<Monster> monsters = monsterService.getAllMonsters();
                if (!monsters.isEmpty()) {
                    monsters.forEach(m -> System.out.println("Monster ID: " + m.getId() + " Monster Name:" + m.getName()));

                    System.out.println("Enter the ID of the monster you want to add: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    Monster monster = monsterService.findById(id);

                    if (monster != null) {
                        item.addMonster(monster);
                        System.out.println("Item added successfully.");
                    } else {
                        System.out.println("Monster not found.");
                    }
                }
            }
            itemService.save(item);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewItems() {
        try{
            List<Item> items = itemService.getAllItems();

            System.out.println("--- Items ---");

            if(!items.isEmpty()){
                items.forEach(System.out::println);
            }
            else{
                System.out.println("No items found.");
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void viewKingdoms() {

        try{
            List<KingdomDTO> kingdoms = kingdomService.getAllKingdoms();

            System.out.println("--- Kingdoms ---");

            if(!kingdoms.isEmpty()){
                kingdoms.forEach(k -> System.out.println("Kingdom:" + k.name() +
                        " Description:" + k.description() +
                        " Allies:" + k.allies() +
                        " Enemies:" + k.enemies()));
            }
            else{
                System.out.println("No kingdoms found.");
            }
        } catch (Exception e){
            System.out.println("Error to find kingdoms " + e.getMessage());
        }
    }

    private void addQuest() {
        try {
            System.out.println("Enter quest title: ");
            String title = scanner.nextLine();

            System.out.println("Enter quest description: ");
            String description = scanner.nextLine();

            Quest quest = new Quest();
            quest.setTitle(title);
            quest.setDescription(description);
            questService.save(quest);

            boolean more = true;
            while (more) {
                System.out.println("Would you like to add characters to the quest? (Y/N)");
                String choice = scanner.nextLine().trim().toUpperCase();

                if (choice.equals("Y")) {
                    List<Character> characters = characterService.findAllCharacters();
                    characters.forEach(c -> System.out.println("Character ID: " + c.getId() + ", Name: " + c.getName()));


                    System.out.println("Which character id do you want to add?");
                    Long idCharacter = scanner.nextLong();
                    scanner.nextLine();

                    Character character = characterService.findCharacterById(idCharacter);

                    if (character != null) {
                        quest.addCharacter(character);
                        questService.save(quest);
                        characterService.save(character);
                        System.out.println("Character added successfully.");
                    } else {
                        System.out.println("Character not found.");
                    }
                } else if (choice.equals("N")) {
                    more = false;
                }
            }

            questService.save(quest);
            System.out.println("Quest added successfully!");

        } catch (Exception e) {
            System.out.println("Quest could not be added: " + e.getMessage());
        }
    }



    private void viewQuests() {
        System.out.println("--- Quests ---");


        try {
            List<Quest> quests = questService.getAllQuests();

            if (quests != null && !quests.isEmpty()) {
                quests.forEach(System.out::println);
            } else {
                System.out.println("No quests");
            }
        } catch (Exception e) {
            System.out.println("Error retrieving quests: " + e.getMessage());
        }
    }

    public static void printMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Add Character");
        System.out.println("2. Add Monster");
        System.out.println("3. View Characters");
        System.out.println("4. View Monsters");
        System.out.println("5. View Quests");
        System.out.println("6. Add Quest");
        System.out.println("7. View Kingdoms");
        System.out.println("8. View Items");
        System.out.println("9. Add Item");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public void addCharacter() {
        System.out.println("\n--- Add New Character ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Gender (Male/Female): ");
        String gender = scanner.nextLine().toLowerCase();

        System.out.print("Category (KING, WITCHER, etc.): ");
        String category = scanner.nextLine().toUpperCase();

        System.out.print("Background: ");
        String background = scanner.nextLine();

        try {
            Character character = new Character(name, gender, CharacterCategory.fromString(category), background);
            characterService.save(character);

            System.out.println("Character added successfully!");

            System.out.println("Wish to add this character to a quest? (Y/N)");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("Y")) {
                try {
                    List<Quest> quests = questService.getAllQuests();

                    if (quests.isEmpty()) {
                        System.out.println("No quests available to add.");
                    } else {
                        quests.forEach(q -> System.out.println("Title: " + q.getTitle()));

                        System.out.println("What quest name would you like to add to this character?");
                        String questName = scanner.nextLine();
                        Quest quest = questService.getQuestByTitle(questName);

                        if (quest != null) {
                            character.getQuestsInvolved().add(quest);
                            characterService.save(character);
                            System.out.println("Quest added successfully!");
                        } else {
                            System.out.println("Quest not found.");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error while trying to add quest: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Character could not be added: " + e.getMessage());
        }
    }


    public void addMonster() {
        System.out.println("\n--- Add New Monster ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Category (NECROPHAGE, RELICT, etc.): ");
        String category = scanner.nextLine().toUpperCase();

        System.out.print("Description: ");
        String description = scanner.nextLine();


        Monster monster = new Monster(name, MonsterCategory.fromString(category), description);
        try {
            monsterService.save(monster); // Save the monster using the service
            System.out.println("Monster added successfully!");
        } catch (Exception e) {
            System.out.println("Monster could not be added" + e.getMessage());
        }
    }

    public void viewCharacters() {
        System.out.println("\n--- Character List ---");

        List<Character> characters = characterService.findAllCharacters();

        if(!characters.isEmpty()) {
            System.out.println("List of registered characters:");
            characters.forEach(c -> System.out.println(c.getName() + "Quests: " + c.getQuestsInvolved()));
        }else {
            System.out.println("No registered characters");
        }

    }

    public void viewMonsters() {
        System.out.println("\n--- Monster List ---");

        List<Monster> monsters = monsterService.getAllMonsters();

        if(!monsters.isEmpty()) {
            System.out.println("List of registered monsters:");
            monsters.forEach(System.out::println);
        }else{
            System.out.println("No registered monsters");
        }

    }
}



