package ladder.refactoring.domain;

public class Participant {

    private final int position;
    private final Name name;

    public Participant(int position, Name name) {
        this.position = position;
        this.name = name;
    }

    public static Participant of(String input) {
        return new Participant(0, Name.of(input));
    }

    public static Participant of(int position, String input) {
        return new Participant(position, Name.of(input));
    }

    public int position() {
        return position;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Participant) {
            Participant other = (Participant) obj;
            return other.name.equals(this.name);
        }
        return false;
    }
}
