package ladder.domain;

import ladder.util.GameUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LineHelper {
    private final int width;

    public LineHelper(int width) {
        validate(width);

        this.width = width;
    }

    private void validate(int width) {
        if (width < GameUtil.MIN_WIDTH) {
            throw new IllegalArgumentException();
        }
    }

    public List<Boolean> generate(Predicate<Boolean> strategy) {
        // Line 의 첫번째 Element 는 항상 false 이다.
        List<Boolean> lineValue = new ArrayList<>(Collections.singletonList(Boolean.FALSE));

        // Line 만들기
        IntStream.range(0, width - 1)
                .mapToObj(lineValue::get)
                .map(strategy::test)
                .forEach(lineValue::add);

        return lineValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineHelper that = (LineHelper) o;
        return width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }
}
