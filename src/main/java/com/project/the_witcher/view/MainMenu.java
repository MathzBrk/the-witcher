package com.project.the_witcher.view;

import com.project.the_witcher.dto.CharacterDTO;
import com.project.the_witcher.dto.MonsterDTO;
import com.project.the_witcher.model.Character;
import com.project.the_witcher.model.CharacterCategory;
import com.project.the_witcher.model.Monster;
import com.project.the_witcher.model.MonsterCategory;
import com.project.the_witcher.service.CharacterService;
import com.project.the_witcher.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.List;

@Component
public class MainMenu {

    private static Scanner scanner = new Scanner(System.in);

    @Autowired
    private CharacterService characterService;
    @Autowired
    private MonsterService monsterService;

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.start();
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            // Display the menu
            printMenu();

            // Read the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left by nextInt()

            // Execute action based on the choice
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
                case 0:
                    exit = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Function to display the main menu
    public static void printMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Add Character");
        System.out.println("2. Add Monster");
        System.out.println("3. View Characters");
        System.out.println("4. View Monsters");
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
        } catch (Exception e) {
            System.out.println("Character could not be added!" + e.getMessage());
        }
    }

    // Function to add a new monster
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

        List<CharacterDTO> characters = characterService.findAllCharacters();

        if(!characters.isEmpty()) {
            System.out.println("List of registered characters:");
            characters.forEach(System.out::println);
        }else {
            System.out.println("No registered characters");
        }

    }

    public void viewMonsters() {
        System.out.println("\n--- Monster List ---");

        List<MonsterDTO> monsters = monsterService.getAllMonsters();

        if(!monsters.isEmpty()) {
            System.out.println("List of registered monsters:");
            monsters.forEach(System.out::println);
        }else{
            System.out.println("No registered monsters");
        }

    }
}



