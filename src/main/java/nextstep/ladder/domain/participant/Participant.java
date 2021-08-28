package nextstep.ladder.domain.participant;

public class Participant {

    private final Name name;

    public Participant(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return this.name.getValue();
    }
}
