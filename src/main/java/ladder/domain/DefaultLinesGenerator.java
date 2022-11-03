package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLinesGenerator implements LinesGenerable {

    final NumberOfLine numberOfLine;
    final LadderHeight ladderHeight;
    final StickDecisionStrategy stickDecisionStrategy;

    public DefaultLinesGenerator(final NumberOfLine numberOfLine, final LadderHeight ladderHeight, final StickDecisionStrategy stickDecisionStrategy) {
        this.numberOfLine = numberOfLine;
        this.ladderHeight = ladderHeight;
        this.stickDecisionStrategy = stickDecisionStrategy;
    }

    public DefaultLinesGenerator(final int numberOfLine, final int ladderHeight, final StickDecisionStrategy stickDecisionStrategy) {
        this(new NumberOfLine(numberOfLine), new LadderHeight(ladderHeight), stickDecisionStrategy);
    }

    @Override
    public List<Line> generate() {
        List<Line> lines = new ArrayList<>();
        for (int index = 0; index < numberOfLine.getValue(); index++) {
            lines.add(createLine(lines, index));
        }
        return lines;
    }

    private Line createLine(List<Line> lines, int index) {
        if (index == 0) {
            return createFirstLine();
        }
        Line lastLine = findLastLine(lines);
        return createNonContinuousLine(lastLine);
    }

    private Line createFirstLine() {
        List<Stick> sticks = IntStream.range(0, ladderHeight.getValue())
                .mapToObj(i -> new Stick(stickDecisionStrategy))
                .collect(Collectors.toList());
        return new Line(sticks);
    }

    private Line findLastLine(List<Line> lines) {
        return lines.stream()
                .skip(lines.size() - 1)
                .findFirst()
                .orElseThrow(IndexOutOfBoundsException::new);
    }

    private Line createNonContinuousLine(Line lastLine) {
        List<Stick> lastLineSticks = lastLine.getSticks();
        List<Stick> sticks = new ArrayList<>();
        lastLineSticks.forEach(stick -> sticks.add(createStick(stick, stickDecisionStrategy)));
        return new Line(sticks);
    }

    private Stick createStick(Stick stick, StickDecisionStrategy stickDecisionStrategy) {
        if (stick.isValue()) {
            return new Stick(false);
        }
        return new Stick(stickDecisionStrategy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultLinesGenerator that = (DefaultLinesGenerator) o;
        return Objects.equals(numberOfLine, that.numberOfLine) && Objects.equals(ladderHeight, that.ladderHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfLine, ladderHeight);
    }

    @Override
    public String toString() {
        return "DefaultLinesGenerator{" +
                "numberOfLine=" + numberOfLine +
                ", ladderHeight=" + ladderHeight +
                '}';
    }
}
