package ladder;

import ladder.util.LadderGameUtil;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Line 의 List<Boolean> field 의 의미는 아래와 같습니다.
 *      [false, false, false] 인 경우
 *     "      |      |      |"
 *
 *      [false, true, false] 인 경우
 *     "      |-----|      |"
 *
 *      [false, true, false, true] 인 경우
 *     "      |-----|      |-----|"
 */
public class Line {
    private final List<Boolean> value;

    public Line(int width) {
        this(LadderGameUtil.autoLineValue(width));
    }

    public Line(List<Boolean> value) {
        validate(value);
        this.value = value;
    }

    private void validate(List<Boolean> value) {
        // 첫번째 다리가 true 인 경우 Exception throw
        if (value.get(0)) {
            throw new IllegalArgumentException();
        }

        // 선이 이어지는 경우에 Exception throw
        value.stream().reduce(false, (left, right) -> {
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
                .map(LadderGameUtil::booleanToLineString)
                .collect(Collectors.joining());
    }
}
