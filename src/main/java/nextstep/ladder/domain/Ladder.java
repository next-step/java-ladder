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

    public String getLadderAsString() {
        List<String> mapAsString = getMapAsString();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ladderRows.size(); i++) {
            builder.append(mapAsString.get(i));
            if (i != mapAsString.size() - 1) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    private List<String> getMapAsString() {
        return ladderRows.stream()
            .map(LadderRow::getRowAsString)
            .collect(Collectors.toList());
    }

    public Point getLadderResultIndex(Point startPoint) {
        Point currentPoint = startPoint;
        for (int i = 0; i < height.getValue(); i++) {
            LadderRow currentStep = ladderRows.get(i);
            if (currentStep.isLeftMoveable(currentPoint)) {
                currentPoint = currentPoint.minus();
                continue;
            }
            if (currentStep.isRightMoveable(currentPoint)) {
                currentPoint = currentPoint.plus();
            }
        }
        return currentPoint;
    }

}
