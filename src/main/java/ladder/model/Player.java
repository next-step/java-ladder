package ladder.model;

public class Player {

    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }
}
