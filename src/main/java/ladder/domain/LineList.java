package ladder.domain;

import ladder.dto.LadderGameRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineList {

    private final List<Line> lineList;

    public LineList(List<Line> lineList) {
        this.lineList = lineList;
    }

    public static LineList of(LadderGameRequest ladderGameRequest) {
        return LineList.of(ladderGameRequest.height(), ladderGameRequest.nameList().length);
    }

    public static LineList of(int size, int pointListSize) {
        List<Line> list = IntStream.range(0, size)
                .mapToObj(i -> Line.init(pointListSize))
                .collect(Collectors.toList());
        return new LineList(list);
    }

    public int size() {
        return lineList.size();
    }

    public List<Line> lineList() {
        return Collections.unmodifiableList(new ArrayList<>(lineList));
    }

    public Position finalPosition(Position startPosition) {
        Position currentPosition = startPosition;
        for (Line line : lineList) {
            currentPosition = line.nextPosition(currentPosition);
        }
        return currentPosition;
    }
}
