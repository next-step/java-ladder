package ladder.domain.result;

import java.util.Objects;

public class Prize {
    private static final String BLANK = "";

    private final String prize;

    public Prize(String rawPrizeValue) {
        checkBlank(rawPrizeValue);
        this.prize = rawPrizeValue;
    }

    private void checkBlank(String rawPrizeValue) {
        if (rawPrizeValue == null || rawPrizeValue.trim().equals(BLANK)) {
            throw new IllegalArgumentException(rawPrizeValue + "는 올바르지 않은 보상입니다.");
        }
    }

    public String getPrize() {
        return this.prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize1 = (Prize) o;
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
