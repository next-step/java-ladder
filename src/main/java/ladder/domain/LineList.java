package ladder.domain;

import ladder.dto.LadderGameRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineList {

    private final List<Line> lineList;

    public LineList() {
        this.lineList = new ArrayList<>();
    }

    public LineList(List<Line> lineList) {
        this.lineList = lineList;
    }

    public static LineList of(LadderGameRequest ladderGameRequest) {
        return LineList.of(ladderGameRequest.height(), ladderGameRequest.nameList().length);
    }

    public static LineList of(int size, int pointListSize) {
        List<Line> list = IntStream.range(0, size)
                .mapToObj(i -> Line.random(pointListSize))
                .collect(Collectors.toList());
        return new LineList(list);
    }

    public void add(List<Point> pointList) {
        lineList.add(Line.of(pointList));
    }

    public int size() {
        return lineList.size();
    }

    public List<Line> lineList() {
        return Collections.unmodifiableList(new ArrayList<>(lineList));
    }

    public Position endLadderNumber(Position startPosition) {
        Position currentPosition = startPosition;
        for (Line line : lineList) {
            Position nextPosition = line.nextLadderNumber(currentPosition);
            currentPosition = nextPosition;
        }
        return currentPosition;
    }
}
