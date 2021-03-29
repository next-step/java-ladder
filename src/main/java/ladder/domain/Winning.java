package ladder.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winning winning1 = (Winning) o;
        return Objects.equals(winning, winning1.winning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winning);
    }
}
