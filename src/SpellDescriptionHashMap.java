import java.util.HashMap;

public class SpellDescriptionHashMap {
    private static HashMap<String,String> spellDescriptions;

    public SpellDescriptionHashMap() {
        spellDescriptions = new HashMap<>();
        spellDescriptions.put("Acid Splash", "On Cast: Caustic acid envelops an area.");
        spellDescriptions.put("Fireball", "On Cast: Hurl a ball of fire at an area.");
        spellDescriptions.put("Fog Cloud", "On cast: Envelops an area in thick fog, completely obscuring vision.");
        spellDescriptions.put("Hideous Laughter", "On successful cast: Cause a creature to laugh uncontrollably, leaving them vulnerable to attack.");
        spellDescriptions.put("Mage Armor", "On cast: Grants the target a spectral armor set. Particularly effective against magical attacks. Target must be you or any allied creature that is not wearing armor.");
        spellDescriptions.put("Vicious Mockery", "On successful cast: Demoralize an enemy creature with a profoundly vile insult, causing it to flee.");
    }

    public void getDescription(String spellName) {
        System.out.println(spellDescriptions.get(spellName));
    }
}
