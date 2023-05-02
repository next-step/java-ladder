package nextstep.ladder.domain.participant;

public class Participant {
    private final Name name;

    public Participant(Name name) {
        this.name = name;
    }

    String getName() {
        return this.name.getName();
    }
}
