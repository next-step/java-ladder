package ladder.domain;

import ladder.util.GameUtil;
import ladder.util.RandomStrategy;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Line 의 List<Boolean> field 의 의미는 아래와 같습니다.
 * [false, false, false] 인 경우
 * "      |      |      |"
 * <p>
 * [false, true, false] 인 경우
 * "      |-----|      |"
 * <p>
 * [false, true, false, true] 인 경우
 * "      |-----|      |-----|"
 */
public class Line {
    private final List<Boolean> value;

    public Line(int width) {
        this(width, new RandomStrategy());
    }

    public Line(int width, Predicate<Boolean> strategy) {
        this(new LineHelper(width).generate(strategy));
    }

    public Line(List<Boolean> value) {
        validate(value);
        this.value = value;
    }

    private void validate(List<Boolean> value) {
        GameUtil.requireNonNullOrSizeGreaterThanZero(value);

        // 첫번째 다리가 true 인 경우 Exception throw
        firstElementValidate(value);

        // 선이 이어지는 경우에 Exception throw
        nearbyElementsValidate(value);
    }

    private void firstElementValidate(List<Boolean> value) {
        if (value.get(0)) {
            throw new IllegalArgumentException();
        }
    }

    private void nearbyElementsValidate(List<Boolean> value) {
        value.stream()
                .reduce((left, right) -> {
                    if (left && right) {
                        throw new IllegalArgumentException();
                    }
                    return right;
                });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(value, line.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.stream()
                .map(GameUtil::booleanToLineString)
                .collect(Collectors.joining());
    }
}
