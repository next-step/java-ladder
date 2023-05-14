package ladder.domain;

public class ParticipantInput{

    private static final String EMPTY_MSG = "참가자 이름은 필수 입력값입니다.";

    private final String participantChunk;

    public ParticipantInput(String participantChunk) {
        if(isEmpty(participantChunk)) {
            throw new IllegalArgumentException(EMPTY_MSG);
        }
        this.participantChunk = participantChunk;
    }

    private boolean isEmpty(String source) {
        return source == null || source.isEmpty();
    }

    public Participants participants() {
        return new Participants(this.participantChunk);
    }
}
