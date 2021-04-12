package ladder.domain;

public final class Participant {

    private final String name;

    private Participant(String name) {
        this.name = name;
    }

    public static final Participant of(String name) {
        return new Participant(name);
    }
}
