package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> bars;

    private Line(List<Boolean> bars) {
        this.bars = bars;
    }

    public static Line ofCount(int barCount) {
        List<Boolean> bars = new ArrayList<>(barCount);

        if (barCount < 1) {
            throw new IllegalArgumentException(String.format("Create Line failed. barCount must be over 0: barCount=%d", barCount));
        }

        Random random = new Random();
        bars.add(random.nextBoolean());
        for (int i = 1; i < barCount; i++) {
            if (bars.get(i - 1)) {
                bars.add(false);
            } else {
                bars.add(random.nextBoolean());
            }
        }

        return new Line(bars);
    }

    public static Line of(Boolean... bar) {
        List<Boolean> bars = Arrays.asList(bar);
        if (bars.size() == 1) {
            return new Line(bars);
        }

        if (isAdjacentBars(bars)) {
            throw new IllegalArgumentException(String.format("Create Line failed. bars should not be adjacent: bars=%s", toString(bars)));
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
}
