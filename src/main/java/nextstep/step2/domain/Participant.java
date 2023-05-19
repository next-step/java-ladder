package nextstep.step2.domain;

public class Participant {

    private static final int PAD_BLANK = 5;

    private final Name name;

    public Participant(String name) {
        this(new Name(name));
    }

    public Participant(Name name) {
        this.name = name;
    }

    public String name() {
        return name.getName();
    }
}
