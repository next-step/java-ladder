package ladder;

public class Player {
    private String name;

    public Player(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNamePad() {
        name += "     ";
        return name.substring(0, 6);
    }
}
