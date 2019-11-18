package ladder.game;

public class Prize {
    private static final int RESULT_MAX_LENGTH = 5;
    private static final String RESULT_LENGTH_EXCEPTION_FORMAT = "사다리게임의 결과는 %d자를 넘을 수 없습니다";
    private String result;

    public Prize(String result) {
        if (result.length() > RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(RESULT_LENGTH_EXCEPTION_FORMAT, RESULT_MAX_LENGTH));
        }
        this.result = result;
    }

    @Override
    public String toString() {
        return result;
    }
}

