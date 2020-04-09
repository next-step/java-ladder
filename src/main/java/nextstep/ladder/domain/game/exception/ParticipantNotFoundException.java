package nextstep.ladder.domain.game.exception;

public class ParticipantNotFoundException extends IllegalArgumentException {
    public ParticipantNotFoundException(String message) {
        super(message);
    }
}
