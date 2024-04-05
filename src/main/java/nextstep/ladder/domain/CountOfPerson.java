package nextstep.ladder.domain;

import java.util.Objects;
import java.util.stream.IntStream;

public class CountOfPerson {
    private final int number;

    public CountOfPerson(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format("사람의 수(%d)는 음수가 될 수 없습니다", number));
        }
        this.number = number;
    }

    public IntStream rangOfZeroToCount() {
        return IntStream.range(0, number - 1);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        CountOfPerson that = (CountOfPerson) object;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
