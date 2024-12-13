package MagicScrolls;

public abstract class AbstractMagicSpells {
    private String name;
    private String description;

    public AbstractMagicSpells() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getName() {
        System.out.println(name);
    }

    public void getDescription() {
        System.out.println(description);
    }
}

