package ladder.domain.ladder;

import ladder.random.PointGenerator;
import ladder.random.RandomPointGenerator;
import ladder.vo.LadderSize;
import ladder.vo.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {
    private final PointGenerator pointGenerator;

    public LadderGenerator() {
        this(new RandomPointGenerator());
    }

    public LadderGenerator(PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    public Ladder generateLadder(LadderSize ladderSize) {
        Length width = ladderSize.getWidth();
        Length height = ladderSize.getHeight();

        List<Line> lines = IntStream.range(0, height.getValue())
                .mapToObj(i -> makeLine(width))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    Line makeLine(Length width) {
        int lineWidth = width.getValue();
        List<Point> points = new ArrayList<>(lineWidth);

        points.add(pointGenerator.generate());

        for (int i = 0; i < lineWidth - 1; i++) {
            Point currentPoint = points.get(i);
            points.add(getNextPoint(currentPoint));
        }

        return new Line(points);
    }

    private Point getNextPoint(Point currentPoint) {
        return ((Point.CROSS == currentPoint) ? Point.NOT_CROSS : pointGenerator.generate());
    }
}
