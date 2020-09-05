package ladder.domain;

public class Participant {
    private final Name name;

    public Participant(Name name) {
        this.name = name;
    }

    public static Participant of(String input) {
        Name name = Name.of(input);
        return new Participant(name);
    }

    @Override
    public String toString() {
        return String.format("%-7s", name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Participant) {
            return name.equals(((Participant) obj).name);
        }
        return false;
    }
}
