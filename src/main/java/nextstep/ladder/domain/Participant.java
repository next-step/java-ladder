package nextstep.ladder.domain;

public class Participant {

    private final Name name;

    public Participant(String name) {
        this.name = new Name(name);
    }

    public static Participant of(String name) {
        return new Participant(name);
    }

    public boolean isSameNameWith(String name) {
        return this.name.is(name);
    }

}
