package ladder.domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Line failed. bars should not be adjacent: bars=%s";

    private final List<Boolean> bars;

    private Line(List<Boolean> bars) {
        this.bars = bars;
    }

    public static Line of(Boolean... bars) {
        return Line.of(Arrays.asList(bars));
    }

    public static Line of(List<Boolean> bars) {
        if (bars.size() == 1) {
            return new Line(bars);
        }

        if (isAdjacentBars(bars)) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, toString(bars)));
        }

        return new Line(bars);
    }

    private static boolean isAdjacentBars(List<Boolean> bars) {
        return IntStream.range(1, bars.size())
                .filter(idx -> bars.get(idx - 1) && bars.get(idx))
                .findFirst()
                .isPresent();
    }

    private static String toString(List<Boolean> bars) {
        return bars.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    public List<Boolean> getBars() {
        return bars;
    }

    LadderNo move(LadderNo no) {
        return Optional.of(no.getLadderNo())
                .filter(this::isExistBar)
                .map(number -> LadderNo.of(number + 1))
                .orElseGet(() -> Optional.of(no.getLadderNo())
                        .map(number -> number - 1)
                        .filter(this::isExistBar)
                        .map(LadderNo::of)
                        .orElse(no));
    }

    private boolean isExistBar(int idx) {
        return -1 < idx && idx < bars.size() && bars.get(idx);
    }

    @Override
    public String toString() {
        return "Line{" +
                "bars=" + bars +
                '}';
    }
}
