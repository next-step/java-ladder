package ladder.domain;

public class Winning {
    private static final String RESULT_MAX_LENGTH_ERROR = "결과는 최대 5글자 입니다.";
    private static final int RESULT_MAX_LENGTH = 5;

    private final String winning;

    public Winning(String winning) {
        validResultLengthFiveOver(winning);
        this.winning = winning;
    }

    private void validResultLengthFiveOver(String result) {
        if (result.isEmpty()
                || result.length() > RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException(RESULT_MAX_LENGTH_ERROR);
        }
    }

    public String winning() {
        return winning;
    }
}
