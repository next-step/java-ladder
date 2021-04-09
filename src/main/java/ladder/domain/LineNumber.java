package ladder.domain;

import java.util.Objects;

public class LineNumber {
    private final int number;

    private LineNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LineNumber valueOf(int number) {
        return new LineNumber(number);
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("유효하지 않은 라인 번호 입니다.");
        }
    }

    public int getLineNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LineNumber that = (LineNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
