package ladder.exception;

public class InvalidForGameResult extends RuntimeException {
    private static final String MESSAGE = "사다리 게임 결과 입력으로 적합하지 않습니다. (입력 결과 수 : %d, 참가자 수 %d)";

    public InvalidForGameResult(int ladderPrizesSize, int countOfParticipants) {
        super(String.format(MESSAGE, ladderPrizesSize, countOfParticipants));
    }
}
