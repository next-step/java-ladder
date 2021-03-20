package laddarGame.domain;

public class Player {

    private Name name;
    private Position position;

    public Player(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }
}
