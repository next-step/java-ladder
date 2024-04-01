package ladder.domain;


public class Gamer {

    private final Name name;
    private final Position position;

    public Gamer(String name, int initPosition) {
        this(new Name(name), new Position(initPosition));
    }

    public Gamer(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Gamer climb(Ladder ladder) {
        return new Gamer(this.name, ladder.move(position));
    }

    public Name getName() {
        return name;
    }
}
