package ladder.domain;

public class Participant {
    private final Name name;

    public Participant(String name) {
        this(new Name(name));
    }

    public Participant(Name name) {
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }
}
