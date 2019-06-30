package ladder;

public class Participant {
    private final Name name;

    public Participant(Name name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }
}
