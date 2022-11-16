package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LadderLineCreator {

    private final RandomValueGenerator randomValueGenerator;

    public LadderLineCreator(final RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    public LadderLine create(final PositiveNumber pointsSize) {
        return new LadderLine(mapToPoints(generateRandomValues(pointsSize)));
    }

    private List<Point> mapToPoints(final List<Boolean> values) {
        return values.stream()
            .map(Point::valueOf)
            .collect(Collectors.toList());
    }

    private List<Boolean> generateRandomValues(final PositiveNumber pointsSize) {
        return Stream.iterate(randomValueGenerator.nextValue(), this::nextValue)
            .limit(pointsSize.intValue())
            .collect(Collectors.toUnmodifiableList());
    }

    private boolean nextValue(final boolean previousValue) {
        if (previousValue) {
            return false;
        }
        return randomValueGenerator.nextValue();
    }
}
