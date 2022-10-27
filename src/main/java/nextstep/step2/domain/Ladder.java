package nextstep.step2.domain;

public class Ladder {

    private final ParticipantName participantName;
    private final int height;

    private Ladder(final ParticipantName participantName, final int height){
        this.participantName = participantName;
        this.height = height;
    }

    public static Ladder of(final ParticipantName participantName, final int height) {
        return new Ladder(participantName, height);
    }

    public ParticipantName getParticipantName() {
        return participantName;
    }

    public int getHeight() {
        return height;
    }
}
