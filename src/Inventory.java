import java.util.Scanner;
import java.util.Random;

public class Inventory {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random DICE_ROLL = new Random();
    private static final int MAX_CONSUMABLES = 8;
    private static final int MAX_WEAPONS = 2;
    private static final int[] CONSUMABLE_SLOTS = {0, 0};
    private static final String[] SPELL_SLOT = {null};
    private static final int[] WEAPON_SLOTS= {0, 0};

    public static void addConsumable() {
        int type;
        int quantity;
        System.out.println(CONSUMABLE_SLOTS[0] + CONSUMABLE_SLOTS[1] + "/" + MAX_CONSUMABLES + " consumables used.");
        System.out.println("Please select the consumable:");
        System.out.println("0. Health Potion");
        System.out.println("1. Mana Potion");
        type = SCANNER.nextInt();
        System.out.println("Please enter the quantity:");
        quantity =SCANNER.nextInt();

        if(CONSUMABLE_SLOTS[0] + CONSUMABLE_SLOTS[1] + quantity >= MAX_CONSUMABLES) {
            System.out.print("ERROR! You can only take ");
            System.out.print(MAX_CONSUMABLES - (CONSUMABLE_SLOTS[0] + CONSUMABLE_SLOTS[1]));
            System.out.println(" more consumables.");
        }
        else if(quantity <= 0) {
            System.out.println("ERROR, please enter a number greater than 0");
        }
        else {
            if(type == 0) {
                CONSUMABLE_SLOTS[0] += quantity;
            }
            else {
                CONSUMABLE_SLOTS[1] += quantity;
            }
        }
    }

    public static void addSpell() {
        String scrollName;
        int result;
        if(SPELL_SLOT[0] != null) {
            System.out.println("ERROR! You need to drop a scroll from your inventory.");
        }
        else {
            System.out.println("You will use your vast powers to conjure 1 of 6 spell scrolls");
            result = DICE_ROLL.nextInt(6);
            if(result == 0) {
                scrollName = "Fireball";
                SPELL_SLOT[0] = scrollName;
                System.out.println("You conjure the scroll to cast " + scrollName);
            }
            else if(result == 1) {
                scrollName = "";
                SPELL_SLOT[0] = scrollName;
                System.out.println("You conjure the scroll to cast " + scrollName);
            }
        }

    }

    public static void addWeapon() {

    }

    public static void droppConsumable() {

    }

    public static void dropSpell() {

    }

    public static void dropWeapon() {

    }

    public static void listConsumables() {
        System.out.println(CONSUMABLE_SLOTS[0] + " health potions" + CONSUMABLE_SLOTS[1] + " mana potions");
    }

    public static void listSpells() {

    }

    public static void listWeapons() {

    }
}
