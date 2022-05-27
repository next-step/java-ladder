package ladder.domain.player;


public class Player {
    private Name name;

    public Player(String name) {
        this.name = new Name(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
