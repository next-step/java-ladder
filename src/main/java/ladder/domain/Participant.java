package ladder.domain;

public class Participant {
    private final ParticipantName participantName;
    private final Position position;

    public Participant(ParticipantName participantName, Position position) {
        this.participantName = participantName;
        this.position = position;
    }

    public Participant(String name, Position position) {
        this(new ParticipantName(name), position);
    }

    public Participant(String name, int x) {
        this(name, new Position(x));
    }

    public String toStringName() {
        return participantName.toString();
    }
}
