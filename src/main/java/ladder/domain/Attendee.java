package ladder.domain;

public class Attendee {

    private String name;

    private Attendee(String name) {
        if(!isValidName(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public static Attendee create(String name) {
        return new Attendee(name);
    }

    private boolean isValidName(String name) {
        return name.length() < 6;
    }

    @Override
    public String toString() {
        return name;
    }
}
