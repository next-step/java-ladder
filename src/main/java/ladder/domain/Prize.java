package ladder.domain;

import java.util.Objects;

public class Prize {
    private final LineNumber lineNumber;
    private final String prize;

    public Prize(int number, String prize) {
        this.lineNumber = LineNumber.valueOf(number);
        this.prize = validate(prize.trim());
    }

    private String validate(String prize) {
        if (prize == null || prize.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 상품입니다.");
        }
        return prize;
    }

    public LineNumber getLineNumber() {
        return this.lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Prize prize1 = (Prize)o;
        return Objects.equals(lineNumber, prize1.lineNumber) && Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineNumber, prize);
    }
}
