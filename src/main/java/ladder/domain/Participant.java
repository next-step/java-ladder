package ladder.domain;

public class Participant {
    private final Name name;
    private final Position position;

    public Participant(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Participant(String name, Position position) {
        this(new Name(name), position);
    }

    public Participant(String name, int x) {
        this(name, new Position(x));
    }

    public String toStringName() {
        return name.toString();
    }
}
