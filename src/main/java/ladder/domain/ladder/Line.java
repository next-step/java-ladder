package ladder.domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Line failed. bars should not be adjacent: bars=%s";

    private final List<Bar> bars;

    private Line(List<Bar> bars) {
        this.bars = bars;
    }

    static Line of(Bar... bars) {
        return Line.of(Arrays.asList(bars));
    }

    public static Line of(List<Bar> bars) {
        if (bars.size() == 1) {
            return new Line(bars);
        }

        if (isAdjacentBars(bars)) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, toString(bars)));
        }

        return new Line(bars);
    }

    private static boolean isAdjacentBars(List<Bar> bars) {
        return IntStream.range(1, bars.size())
                .filter(idx -> bars.get(idx - 1).isExist() && bars.get(idx).isExist())
                .findFirst()
                .isPresent();
    }

    private static String toString(List<Bar> bars) {
        return bars.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    public List<Bar> getBars() {
        return bars;
    }

    LadderNumber move(LadderNumber no) {
        return Optional.of(no.getLadderNo())
                .filter(this::isExistBar)
                .map(number -> LadderNumber.of(number + 1))
                .orElseGet(() -> Optional.of(no.getLadderNo())
                        .map(number -> number - 1)
                        .filter(this::isExistBar)
                        .map(LadderNumber::of)
                        .orElse(no));
    }

    int size(){
        return bars.size();
    }

    private boolean isExistBar(int idx) {
        return -1 < idx && idx < bars.size() && bars.get(idx).isExist();
    }

    @Override
    public String toString() {
        return "Line{" +
                "bars=" + bars +
                '}';
    }
}
