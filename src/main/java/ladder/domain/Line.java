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
                        throw new IllegalArgumentException("유효하지 않은 사다리입니다.");
                    }
                    return right;
                });
    }

    public int nextPosition(int currPos) {
        try {
            this.value.add(Boolean.FALSE);

            // 자신의 위치에서 왼쪽으로 뻗는 길이 있는 경우
            if (value.get(currPos)) {
                return currPos - 1;
            }

            // 자신의 위치 오른쪽에서 뻗어오는 길이 있는 경우
            if (value.get(currPos + 1)) {
                return currPos + 1;
            }

            // 그 외 나머지 경우는 현재 위치 그대로
            return currPos;
        } finally {
            this.value.remove(this.value.size() - 1);
        }
    }

    public int size() {
        return this.value.size();
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
