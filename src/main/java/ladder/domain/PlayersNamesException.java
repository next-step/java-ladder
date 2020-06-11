package ladder.domain;

public class PlayersNamesException extends RuntimeException {
    public static final String MESSAGE = "참가자의 이름 1개 이상이 필요합니다.";

    public PlayersNamesException() {
        super(MESSAGE);
    }
}
