package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final PositiveNumber height;
    private final List<Line> lines;

    public Ladder(PositiveNumber width, PositiveNumber height) {
        this.height = height;
        this.lines = new ArrayList<>();
        makeLine(width, height);
    }

    public Ladder(PositiveNumber height, List<Line> lines) {
        this.height = height;
        this.lines = lines;
    }

    private void makeLine(PositiveNumber width, PositiveNumber height) {
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new Line(width, RandomBarGeneratorStrategy.getInstance()));
        }
    }

    public List<Line> getLadderRows() {
        return Collections.unmodifiableList(lines);
    }

    private List<String> getMapAsString() {
        return lines.stream()
            .map(Line::getRowAsString)
            .collect(Collectors.toList());
    }

    // 시작 지점을 매개변수로 받는 run 메서드. 사다리 게임 후 마지막 인덱스를 반환한다.
    public int run(int startPoint) {
        int currentPoint = startPoint;
        for (int i = 0; i < height.getValue(); i++) {
            currentPoint = getNextPoint(currentPoint, lines.get(i));
        }
        return currentPoint;
    }

    private int getNextPoint(int currentPoint, Line line) {
        if (line.isLeftMoveable(currentPoint)) {
            return currentPoint - 1;
        }
        if (line.isRightMoveable(currentPoint)) {
            return currentPoint + 1;
        }
        return currentPoint;
    }

    @Override
    public String toString() {
        List<String> mapAsString = getMapAsString();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mapAsString.size(); i++) {
            appendLine(builder, mapAsString.get(i), i);
        }
        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line, int index) {
        builder.append(line);
        if (index != getMapAsString().size() - 1) {
            builder.append("\n");
        }
    }

}
