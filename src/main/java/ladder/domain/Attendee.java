package ladder.domain;

public class Attendee {

    private String name;

    private Attendee(String name) {
        this.name = name;
    }

    public static Attendee create(String name) {
        return new Attendee(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
