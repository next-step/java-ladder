package ladder.domain;

import java.util.Objects;

public class Prize {
    private final static int MAX_PRIZE_LENGTH = 5;
    private final static int MIN_PRIZE_LENGTH = 1;
    private final static String BLANK = " ";

    private final String value;

    public Prize(String input) {
        checkValidPrize(input);
        this.value = input;
    }

    private void checkValidPrize(String prize) {
        if (prize.contains(BLANK)) {
            throw new IllegalArgumentException("결과값은 공백을 포함할 수 없습니다.");
        }

        if (!isValidLength(prize)) {
            throw new IllegalArgumentException("결과값은 1자 이상 5자 이하여야 합니다.");
        }
    }

    private boolean isValidLength(String prize) {
        return prize.length() >= MIN_PRIZE_LENGTH && prize.length() <= MAX_PRIZE_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return Objects.equals(value, prize.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
