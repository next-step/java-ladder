package nextstep.ladder.domain.line;

import java.util.List;

import nextstep.ladder.domain.Count;

@FunctionalInterface
public interface LineGenerateStrategy {
    default List<Boolean> generate(final Count count) {
        if (count == null) {
            throw new IllegalArgumentException("invalid input: count cannot be null");
        }

        final List<Boolean> points = generatePoints(count);

        if (points.size() != count.toInt()) {
            throw new IllegalArgumentException("invalid line: generated size is not match");
        }

        return points;
    }

    List<Boolean> generatePoints(final Count count);
}