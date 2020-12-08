package step3.domain;

public class ParticipantPosition {

    private final int position;

    private ParticipantPosition(int position) {
        this.position = position;
    }

    public static ParticipantPosition of(int position) {
        return new ParticipantPosition(position);
    }

    public int getPosition() {
        return this.position;
    }
}
