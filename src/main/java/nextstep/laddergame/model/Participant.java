package nextstep.laddergame.model;

public class Participant {

    private final Name Name;

    public Participant(String name) {
        this(new Name(name));
    }

    public Participant(Name name) {
        Name = name;
    }
}
