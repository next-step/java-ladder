package ladder.game;

public class Participant {
    private static final int PARTICIPANT_NAME_MAX_LENGTH = 5;
    private static final String PARTICIPANT_NAME_MAX_LENGTH_EXCEPTION = "참여자의 이름은 %d글자를 넘을 수 없습니다";

    private final String name;

    public Participant(String participant) {
        if (participant.length() > PARTICIPANT_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(PARTICIPANT_NAME_MAX_LENGTH_EXCEPTION, PARTICIPANT_NAME_MAX_LENGTH));
        }
        this.name = participant;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
