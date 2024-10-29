package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final PositiveNumber height;
    private final List<LadderRow> ladderRows;

    public Ladder(PositiveNumber width, PositiveNumber height) {
        this.height = height;
        this.ladderRows = new ArrayList<>();
        makeMap(width, height);
    }

    public Ladder(PositiveNumber height, List<LadderRow> ladderRows) {
        this.height = height;
        this.ladderRows = ladderRows;
    }

    private void makeMap(PositiveNumber width, PositiveNumber height) {
        for (int i = 0; i < height.getValue(); i++) {
            ladderRows.add(new LadderRow(width, RandomBarGeneratorStrategy.getInstance()));
        }
    }

    public List<LadderRow> getLadderRows() {
        return Collections.unmodifiableList(ladderRows);
    }

    private List<String> getMapAsString() {
        return ladderRows.stream()
            .map(LadderRow::getRowAsString)
            .collect(Collectors.toList());
    }

    public Point getLadderResultIndex(Point startPoint) {
        Point currentPoint = startPoint;
        for (int i = 0; i < height.getValue(); i++) {
            currentPoint = getNextPoint(currentPoint, ladderRows.get(i));
        }
        return currentPoint;
    }

    private Point getNextPoint(Point currentPoint, LadderRow ladderRow) {
        if (ladderRow.isLeftMoveable(currentPoint)) {
            return currentPoint.minus();
        }
        if (ladderRow.isRightMoveable(currentPoint)) {
            return currentPoint.plus();
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
