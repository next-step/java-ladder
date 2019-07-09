package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {
    private final List<Line> lines;

    public Lines(int lineQuantity) {
        this.lines = new ArrayList<>();
        IntStream.range(0, lineQuantity)
                .mapToObj(i -> Line.of(false))
                .forEach(lines::add);
    }

    private Lines(List<Line> lines) {
        this.lines = lines;
        validate();
    }

    public static Lines of(LineGenerator lineGenerator) {
        List<Line> lines = lineGenerator.getLineBase()
                .stream()
                .map(Line::of)
                .collect(Collectors.toList());
        return new Lines(lines);
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int move(int index) {
        if (hasLeftLine(index)) {
            return index - 1;
        }
        if (hasRightLine(index)) {
            return index + 1;
        }
        return index;
    }

    private void validate() {
        checkFirstLineFalse();
        allLineLineHasNoNeighborLine();
    }

    private void checkFirstLineFalse() {
        if (lines.get(0).hasLine()) {
            throw new IllegalArgumentException("첫번째 Line 은 Line 을 가질 수 없습니다.");
        }
    }

    private boolean hasLeftLine(int index) {
        if (index == 0) {
            return false;
        }
        return lines.get(index).hasLine();
    }

    private boolean hasRightLine(int index) {
        if (index == lines.size() - 1) {
            return false;
        }
        return lines.get(index + 1).hasLine();
    }

    private boolean hasLineAndHasNeighborLine(int index) {
        return hasLeftLine(index) && hasRightLine(index);
    }

    private void allLineLineHasNoNeighborLine() {
        if (IntStream.range(0, lines.size())
                .mapToObj(this::hasLineAndHasNeighborLine)
                .anyMatch(aBoolean -> aBoolean)) {
            throw new IllegalArgumentException("연속으로 Line 이 있는 Lines 입니다.");
        }
    }
}
