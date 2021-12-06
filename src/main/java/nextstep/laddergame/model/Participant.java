package nextstep.laddergame.model;

public class Participant {

    private final Name name;

    public Participant(Name name) {
        this.name = name;
    }

    public static Participant from(String name) {
        return new Participant(new Name(name));
    }

    public Name name() {
        return name;
    }
}
