package nextstep.step2.domain;

public class Participant {

    private final Name name;

    public Participant(String name) {
        this(new Name(name));
    }

    public Participant(Name name) {
        this.name = name;
    }

    public String toNameString() {
        return name.getName();
    }
}
