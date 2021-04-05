package nextstep.ladder.domain;

public class Participant {

    private String name;

    private Participant(final String name) {
        this.name = name;
    }

    public static Participant of(final String name) {
        return new Participant(name);
    }
}
