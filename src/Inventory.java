import java.util.Scanner;
import java.util.Random;

public class Inventory {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random DICE_ROLL = new Random();
    private static final int MAX_CONSUMABLES = 8;
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
            System.out.println("You will use your vast powers to conjure 1 of 6 spell scrolls.");
            result = DICE_ROLL.nextInt(6);
            if(result == 0) {
                scrollName = "Fireball";
                SPELL_SLOT[0] = scrollName;
                System.out.println("You conjure the scroll to cast " + scrollName + ".");
                System.out.println("On cast: Hurl a ball of fire at an area.");
            }
            else if(result == 1) {
                scrollName = "Vicious Mockery";
                SPELL_SLOT[0] = scrollName;
                System.out.println("You conjure the scroll to cast " + scrollName + ".");
                System.out.println("On successful cast: Demoralize a creature with a profoundly vile insult, causing it to flee.");
            }
            else if(result == 2) {
                scrollName = "Acid Splash";
                SPELL_SLOT[0] = scrollName;
                System.out.println("You conjure the scroll to cast " + scrollName);
                System.out.println("On cast: Caustic acid envelops an area. Reacting with almost everything it touches.");
            }
            else if(result == 3) {
                scrollName = "Hideous Laughter";
                SPELL_SLOT[0] = scrollName;
                System.out.println("You conjure the scroll to cast " + scrollName);
                System.out.print("On successful cast: You tell a joke so funny the target creature can't help but");
                System.out.println(" laugh so hard they fall to the ground, unable to defend themselves.");
            }
            else if(result == 4) {
                scrollName = "Fog Cloud";
                SPELL_SLOT[0] = scrollName;
                System.out.println("You conjure the scroll to cast " + scrollName);
                System.out.println("On cast: Envelops an area in thick fog, completely obscuring vision.");
            }
            else {
                scrollName = "Mage Armor";
                SPELL_SLOT[0] = scrollName;
                System.out.println("You conjure the scroll to cast " + scrollName);
                System.out.print("On cast: Grants you or any ally not wearing armor a spectral armor set.");
                System.out.println(" Particularly effective against magical attacks.");
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