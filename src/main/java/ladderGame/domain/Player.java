package ladderGame.domain;

public class Player {

    private final int position;
    private final String name;

    private Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Player of(String name, int position) {
        return new Player(name, position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
