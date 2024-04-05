package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Height {
    private final int number;

    public Height(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
        this.number = number;
    }

    public void add(List<Line> lines, int countOfPerson) {
        for (int i = 0; i < number; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Height height = (Height) object;
        return number == height.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
