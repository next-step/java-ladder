package ladder.domain.ladder;

public class LadderResultException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "참가자의 수와 상금의 수가 일치하지 않습니다. 참가자 수 : %d, 상금 수 : %d";

    public LadderResultException(int sizeOfPlayers, int sizeOfAwards) {
        super(String.format(DEFAULT_MESSAGE, sizeOfPlayers, sizeOfAwards));
    }
}
