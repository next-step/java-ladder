package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Line failed. bars should not be adjacent: bars=%s";

    private final List<Bar> bars;

    private Line(List<Bar> bars) {
        validationCheck(bars);

        this.bars = Collections.unmodifiableList(bars);
    }

    private void validationCheck(List<Bar> bars) {
        if(isSizeOverZero(bars) && isAdjacentBars(bars)){
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, toString(bars)));
        }
    }

    private boolean isAdjacentBars(List<Bar> bars) {
        return IntStream.range(1, bars.size())
                .filter(idx -> bars.get(idx - 1).isExist() && bars.get(idx).isExist())
                .findFirst()
                .isPresent();
    }

    private boolean isSizeOverZero(List<Bar> bars) {
        return bars.size() > 1;
    }

    public static Line of(List<Bar> bars) {
        return new Line(bars);
    }

    private static String toString(List<Bar> bars) {
        return bars.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }

    List<Boolean> getBarExists() {
        return bars.stream()
                .map(Bar::isExist)
                .collect(Collectors.toList());
    }

    LadderNumber move(LadderNumber ladderNumber) {
        return Optional.of(ladderNumber.getNumber())
                .filter(this::isExistBar)
                .map(number -> LadderNumber.of(number + 1))
                .orElseGet(() -> Optional.of(ladderNumber.getNumber())
                        .map(number -> number - 1)
                        .filter(this::isExistBar)
                        .map(LadderNumber::of)
                        .orElse(ladderNumber));
    }

    int size() {
        return bars.size();
    }

    private boolean isExistBar(int idx) {
        return (-1 < idx && idx < bars.size()) && bars.get(idx).isExist();
    }

    @Override
    public String toString() {
        return "Line{" +
                "bars=" + bars +
                '}';
    }
}
