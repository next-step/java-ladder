package nextstep.domain.ladder;

import nextstep.domain.line.Line;
import nextstep.domain.line.Point;
import nextstep.generator.PointGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final PointGenerator pointGenerator;

    public Ladder(int playerCounts, Height height, PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
        this.lines = makeLadder(playerCounts, height);
    }

    private List<Line> makeLadder(int playerCounts, Height height) {
        return IntStream.range(0, height.getHeight())
                .mapToObj(line -> new Line(playerCounts, pointGenerator))
                .collect(Collectors.toList());
    }

    public List<Line> getAllLines() {
        return lines;
    }

    public int countHeight() {
        return lines.size();
    }

    public int countAllLines(){
        return (int) lines.stream()
                .mapToLong(line -> line.getPoints().size())
                .sum();
    }
}
