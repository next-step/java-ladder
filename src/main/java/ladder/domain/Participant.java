package ladder.domain;

public class Participant {
    private final Name name;

    private Participant(Name name) {
        this.name = name;
    }

    public static Participant from(String name) {
        return new Participant(Name.from(name));
    }

    public String getName() {
        return name.getName();
    }
}
