package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class LadderLineCreatorImpl implements LadderLineCreator {

    private final RandomValueGenerator randomValueGenerator;

    public LadderLineCreatorImpl(final RandomValueGenerator randomValueGenerator) {
        this.randomValueGenerator = randomValueGenerator;
    }

    @Override
    public LadderLine create(final PositiveNumber pointsSize) {
        return new LadderLine(mapToPoints(generateRandomValues(pointsSize)));
    }

    private List<Point> mapToPoints(final List<Boolean> values) {
        return values.stream()
            .map(Point::valueOf)
            .collect(Collectors.toList());
    }

    private List<Boolean> generateRandomValues(final PositiveNumber pointsSize) {
        final List<Boolean> result = new ArrayList<>();
        boolean previousValue = randomValueGenerator.nextValue();
        for (PositiveNumber i = PositiveNumber.ONE;
            i.isLessThanOrEquals(pointsSize);
            i = i.plus(PositiveNumber.ONE)){

            final boolean currentValue = nextValue(previousValue);

            result.add(currentValue);

            previousValue = currentValue;
        }
        return Collections.unmodifiableList(result);
    }

    private boolean nextValue(final boolean previousValue) {
        if (previousValue) {
            return false;
        }
        return randomValueGenerator.nextValue();
    }
}
