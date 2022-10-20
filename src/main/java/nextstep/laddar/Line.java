package nextstep.laddar;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> positions;

    public Line(int countOfPerson) {
        this.positions = IntStream.range(0, countOfPerson)
                .mapToObj((i) -> false)
                .collect(Collectors.toList());
    }

    public void putHorizontalLine(int position, BooleanGenerator booleanGenerator) {
        Optional.of(position)
                .filter(pos -> !hasHorizontalLine(pos))
                .filter(pos -> !hasNearHorizontalLine(pos))
                .ifPresent(pos -> this.positions.set(pos, booleanGenerator.generate()));
    }

    public boolean hasNearHorizontalLine(int position) {
        int rangeNumber = Optional.of(position)
                .filter(this::isRangePosition)
                .orElseThrow(() -> new IllegalArgumentException("해당 위치에는 다리를 놓을 수 없습니다."));

        boolean hasLeftLine = Optional.of(rangeNumber)
                .filter(number -> number > 0 && positions.get(number - 1).equals(true))
                .isPresent();
        boolean hasRightLine = Optional.of(rangeNumber)
                .filter(number -> number < positions.size() - 1 && positions.get(number + 1).equals(true))
                .isPresent();

        return hasLeftLine || hasRightLine;
    }

    boolean hasHorizontalLine(int position) {
        return Optional.of(
                        Optional.of(position)
                                .filter(this::isRangePosition)
                                .orElseThrow(() -> new IllegalArgumentException("해당 위치에는 다리를 놓을 수 없습니다."))
                )
                .map(positions::get)
                .filter(hasLine -> hasLine.equals(true))
                .isPresent();
    }

    private boolean isRangePosition(Integer pos) {
        return pos < positions.size() && pos >= 0;
    }

    public void makeHorizontalLines(BooleanGenerator booleanGenerator) {
        IntStream.range(0, positions.size())
                .forEach((idx) -> putHorizontalLine(idx, booleanGenerator));
    }

    public List<Boolean> getPositions() {
        return positions;
    }
}

