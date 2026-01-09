package nextstep.laddergame.domain.participant;

public record Participant(Name name, Position position) {

    public Participant(String name) {
        this(new Name(name), new Position(0));
    }

    public Participant(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Participant {
    }

}
