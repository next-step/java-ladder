package nextstep.laddergame.model;

public class Participant {

    private final Name name;

    public Participant(String name) {
        this(new Name(name));
    }

    public Participant(Name name) {
        this.name = name;
    }

    public Name name() {
        return name;
    }
}
