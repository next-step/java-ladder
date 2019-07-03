package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HorizontalLines {
    private final List<HorizontalLine> horizontalLines;

    public HorizontalLines(int lineQuantity) {
        this.horizontalLines = new ArrayList<>();
        IntStream.range(0, lineQuantity)
                .mapToObj(i -> HorizontalLine.of(false))
                .forEach(horizontalLines::add);
    }

    private HorizontalLines(List<HorizontalLine> horizontalLines) {
        this.horizontalLines = horizontalLines;
        validate();
    }

    public static HorizontalLines of(LadderGenerator ladderGenerator) {
        List<HorizontalLine> horizontalLines = ladderGenerator.getLadderBase()
                .stream()
                .map(HorizontalLine::of)
                .collect(Collectors.toList());
        return new HorizontalLines(horizontalLines);
    }

    public int size() {
        return horizontalLines.size();
    }

    public List<HorizontalLine> getHorizontalLines() {
        return Collections.unmodifiableList(horizontalLines);
    }

    private void validate() {
        checkFirstLineFalse();
        allHorizontalLineLineHasNoNeighborLine();
    }

    private void checkFirstLineFalse() {
        if (horizontalLines.get(0).hasLine()) {
            throw new IllegalArgumentException("첫번째 HorizontalLine 은 Line 을 가질 수 없습니다.");
        }
    }

    private boolean hasLineAndHasNeighborLine(int index) {
        if (!horizontalLines.get(index).hasLine() || index == 0) {
            return false;
        }
        if (index == horizontalLines.size() - 1) {
            return horizontalLines.get(index - 1).hasLine();
        }
        return horizontalLines.get(index - 1).hasLine() || horizontalLines.get(index + 1).hasLine();
    }

    private void allHorizontalLineLineHasNoNeighborLine() {
        if (IntStream.range(0, horizontalLines.size())
                .mapToObj(this::hasLineAndHasNeighborLine)
                .anyMatch(aBoolean -> aBoolean)) {
            throw new IllegalArgumentException("연속으로 Line 이 있는 HorizontalLines 입니다.");
        }
    }
}
