package ladder.domain.ladder.maker;


import ladder.domain.ladder.Bar;
import ladder.domain.ladder.Line;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RandomLadderMaker implements MakeLadderStrategy {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Line failed. " +
            "size and height must be at least %d: size=%d, height=%d";
    private static final int MINIMUM_COUNT = 1;

    private final Random random = new Random();
    private final int size;
    private final int height;

    RandomLadderMaker(int size, int height) {
        if (isGreaterThenEqualsMinimum(size, height)) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, MINIMUM_COUNT, size, height));
        }

        this.size = size;
        this.height = height;
    }

    private boolean isGreaterThenEqualsMinimum(int size, int height) {
        return size < MINIMUM_COUNT ||
                height < MINIMUM_COUNT;
    }

    @Override
    public List<Line> makeBarLines() {
        return Stream.iterate(makeLine(), line -> makeLine())
                .limit(height)
                .collect(Collectors.toList());
    }

    private Line makeLine() {
        return Line.of(getBarList());
    }

    private List<Bar> getBarList() {
        return Stream.iterate(random.nextBoolean(), this::getNextBar)
                .limit(size)
                .map(Bar::of)
                .collect(Collectors.toList());
    }

    private Boolean getNextBar(Boolean beforeBar) {
        return !beforeBar && random.nextBoolean();
    }
}
