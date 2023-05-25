package nextstep.ladder.domain;


import nextstep.ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private static final String HEIGHT_ERROR_MESSAGE = "높이는 0보다 커야 합니다.";

    private List<Line> lines;

    private int height;

    public Ladder(int height, int width) {
        if (1 > height) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSAGE);
        }
        this.height = height;
        lines = createLines(width);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    public int getPlayerResultIndex(int currentPoint) {
        int point = currentPoint;
        for (int index = 0; index < this.height; index++) {
            point = calculationPoint(index, point, this);
        }
        return point;
    }

    // TODO 해야함 졸려서잠
    private int calculationPoint(int lineIndex, int point, Ladder ladder) {
        Line line = ladder.getLines().get(lineIndex);
        if (line.hasLeftPoint(point)) {
            return point - 1;
        }
        if (line.hasRightPoint(point)) {
            return point + 1;
        }
        return point;
    }

    private List<Line> createLines(int width) {
        List<Line> lines = new ArrayList<>();
        for (int heightNumber = 0; heightNumber < height; heightNumber++) {
            lines.add(
                    new Line(
                            Line.generatePoints(() -> new Point(PointStatus.getRandomStatus(PointStatus.values().length)), width)
                    )
            );
        }
        return lines;
    }

}
