package ladder.domain;

import ladder.util.GameUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class LadderHelper {
    private final int width;
    private final int height;

    public LadderHelper(int width, int height) {
        validate(width, height);

        this.width = width;
        this.height = height;
    }

    private void validate(int width, int height) {
        if (width < GameUtil.MIN_WIDTH || height < GameUtil.MIN_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }

    public List<Line> generate(Predicate<Boolean> strategy) {
        List<Line> ladderValue = new ArrayList<>();

        // Ladder 만들기
        IntStream.range(0, height)
                .mapToObj(i -> new Line(width, strategy))
                .forEach(ladderValue::add);

        return ladderValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHelper that = (LadderHelper) o;
        return width == that.width && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
