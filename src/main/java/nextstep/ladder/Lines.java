package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines generateRandomly(LadderHeight ladderHeight, int ladderWidth) {
        List<Line> lines = IntStream.range(0, ladderHeight.get())
                .mapToObj(i -> Line.generate(ladderWidth, () -> Math.random() < 0.5 ? Point.RIGHT : Point.NONE))
                .collect(Collectors.toList());
        return new Lines(lines);
    }

    public List<Line> getListLines() {
        return lines;
    }

    public int getIndexAfterMove(int startIndex) {
        int movedIndex = startIndex;
        for (Line line : lines) {
            movedIndex = line.getIndexAfterMove(movedIndex);
        }
        return movedIndex;
    }
}
