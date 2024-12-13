import java.util.Scanner;
import java.util.Random;

public class Inventory {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random DICE_ROLL = new Random();
    private static final int MAX_WEAPONS = 2;
    private static final int MAX_CONSUMABLES = 8;
    private static final int[] CONSUMABLE_SLOTS = {0, 0};
    private static final String[] SPELL_SLOT = {null};
    private static final String[] WEAPON_SLOTS= {null, null};

    public Inventory() {

    }

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

    public static String conjureSpell(String spellName) {

        return spellName;
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

    public static void droppConsumable() {

    }

    public static void dropSpell() {

    }

    public static void dropWeapon() {

    }

    public static void listConsumables() {
        System.out.println(CONSUMABLE_SLOTS[0] + " health potions" + CONSUMABLE_SLOTS[1] + " mana potions");
    }

    public static void listSpell() {
        if(SPELL_SLOT[0] == null) {
            System.out.println("You do not have a spell equipped. Equip one by conjuring a scroll.");
        }
        else {
            System.out.println("You have the " + SPELL_SLOT[0] + " scroll equipped.");
        }
    }

    public static void listWeapons() {

    }
}
