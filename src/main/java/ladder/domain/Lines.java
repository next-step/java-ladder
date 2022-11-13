package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import ladder.strategy.LinkStrategy;

public class Lines {

    private final static String ERROR_ZERO_OR_NEGATIVE_VALUE = "0보다 큰 값만 입력 가능합니다.";

    private final List<Line> value = new ArrayList<>();

    public Lines(final int row, final int column) {
        validate(row);
        validate(column);

        IntStream.range(0, row)
            .mapToObj(i -> new Line(new PositiveInt(i), new PositiveInt(column)))
            .forEach(value::add);
    }

    private void validate(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(ERROR_ZERO_OR_NEGATIVE_VALUE);
        }
    }

    public void draw(final LinkStrategy strategy) {
        value.forEach(line -> line.link(strategy));
    }

    public int move(final int startColumnNumber) {
        AtomicInteger currentColumnNumber = new AtomicInteger(startColumnNumber);
        value.forEach(line -> {
            currentColumnNumber.set(line.move(currentColumnNumber.get()));
        });

        return currentColumnNumber.get();
    }

    public List<Line> getValue() {
        return Collections.unmodifiableList(value);
    }
}
