/*
 * Rather than doing all of our work in the Main class, I encapsulated the code into this separate class.
 * The Main class will create an Inventory object and that object will use the methods within this Inventory class.
 */

import java.util.Scanner;
import java.util.Random;

public class Inventory {
    private static Scanner scanner;
    private static Random diceRoll;
    private static int maxWeapons;
    private static int maxConsumables;
    private static int[] consumableSlots;
    private static String[] spellSlot;
    private static  String[] weaponSlots;
    private static SpellDescriptionHashMap spellDescriptions;

    public Inventory() {
        scanner = new Scanner(System.in);
        diceRoll = new Random();
        maxWeapons = 2;
        maxConsumables = 8;
        consumableSlots = new int[] {0, 0};
        spellSlot = new String[] {null};
        weaponSlots = new String[] {null, null};
        spellDescriptions = new SpellDescriptionHashMap();
    }
    public static void addConsumable() {
        int type;
        int quantity;

        System.out.println(consumableSlots[0] + consumableSlots[1] + "/" + maxConsumables + " consumables used.");
        System.out.println("Please select the consumable:");
        System.out.println("0. Health Potion");
        System.out.println("1. Mana Potion");
        type = scanner.nextInt();
        System.out.println("Please enter the quantity:");
        quantity = scanner.nextInt();

        if(consumableSlots[0] + consumableSlots[1] + quantity >= maxConsumables) {
            System.out.print("ERROR! You can only take ");
            System.out.print(maxConsumables - (consumableSlots[0] + consumableSlots[1]));
            System.out.println(" more consumables.");
        }
        else if(quantity <= 0) {
            System.out.println("ERROR, please enter a number greater than 0");
        }
        else {
            if(type == 0) {
                consumableSlots[0] += quantity;
            }
            else {
                consumableSlots[1] += quantity;
            }
        }
    }

    public static String conjureSpell() {
        int result;
        String spellName;
        System.out.println("You will use your vast powers to conjure one of six magical spells.");
        result = diceRoll.nextInt(6);

        spellName = switch (result) {
            case 0 -> "Acid Splash";
            case 1 -> "Fireball";
            case 2 -> "Fog Cloud";
            case 3 -> "Hideous Laughter";
            case 4 -> "Mage Armor";
            case 5 -> "Vicious Mockery";
            default -> null;
        };

        System.out.println("You conjured the spell: " + spellName);
        return spellName;
    }

    public static void addSpell() {
        spellSlot[0] = conjureSpell();
    }

    public static void addWeapon() {
        int handSelector;

        System.out.println("Select a weapon type: ");
        System.out.println("0. Axe");
        System.out.println("1. Mace");
        System.out.println("2. Sword");
        System.out.println("3. Talisman");
        System.out.println("4. Sorcerer's Staff");
    }

    public static void dropConsumable() {
        int potionSelector;
        int quantity;

        listConsumables();
        System.out.println("Select the potion to drop:");
        System.out.println("0. Health Potion");
        System.out.println("1. Mana Potion");
        potionSelector = scanner.nextInt();
        System.out.println("Enter the amount to drop:");
        quantity = scanner.nextInt();

        if(potionSelector == 0) {
            if(consumableSlots[0] == 0) {
                System.out.println("ERROR! You don't have any health potions in your inventory.");
            }
            else if(consumableSlots[0] < quantity) {
                System.out.println("ERROR! You can only drop a maximum of " + consumableSlots[0] + " potion(s)!");
            }
            else {
                consumableSlots[0] -= quantity;
                System.out.println("You dropped " + quantity + "health potion(s).");
            }
        }
        else {
            if(consumableSlots[1] == 0) {

                System.out.println("ERROR! You don't have any mana potions in your inventory.");
            }
            else if(consumableSlots[1] < quantity) {
                System.out.println("ERROR! You can only drop a maximum of " + consumableSlots[0] + " potion(s)!");
            }
            else {
                consumableSlots[1] -= quantity;
                System.out.println("You dropped " + quantity + " mana potion(s).");
            }
        }
    }

    public static void dropSpell() {
        spellSlot[0] = null;
        System.out.println("You've dropped your previously equipped spell");
    }

    public static void dropWeapon() {
        int slotSelector = scanner.nextInt();
        System.out.println("Please select the weapon slot to empty:");
        System.out.println("0. Weapon Slot 1");
        System.out.println("1. Weapon Slot 2");

        if(slotSelector == 0) {
            weaponSlots[0] = null;
        }
        else {
            weaponSlots[1] = null;
        }


    }

    public static void listConsumables() {
        System.out.println("You have " + consumableSlots[0] + " health potions" + consumableSlots[1] + " mana potions");
    }

    public static void listSpell() {

        if(spellSlot[0] == null) {
            System.out.println("You do not have a spell equipped. Equip one by conjuring a scroll.");
        }
        else {
            System.out.println("You have the " + spellSlot[0] + " scroll equipped.");
            spellDescriptions.getDescription(spellSlot[0]);
        }
    }

    public static void listWeapons() {

    }
}
