package ladder.game;

public class Prize {
    private static final int RESULT_MAX_LENGTH = 5;
    private static final String RESULT_LENGTH_EXCEPTION_FORMAT = "사다리게임의 결과는 %d자를 넘을 수 없습니다";
    private final String prize;

    public Prize(String prize) {
        verifyPrizeNameLength(prize);
        this.prize = prize;
    }

    private void verifyPrizeNameLength(String prize) {
        if (prize.length() > RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(RESULT_LENGTH_EXCEPTION_FORMAT, RESULT_MAX_LENGTH));
        }
    }

    @Override
    public String toString() {
        return prize;
    }
}

