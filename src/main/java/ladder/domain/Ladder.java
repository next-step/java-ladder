package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    public static final String ALL_RESULT = "all";

    private final List<Line> lines;
    private final PositionGroup positionGroup;

    public Ladder(Height height, PositionGroup positionGroup) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(positionGroup.playerPositions()));
        }
        this.lines = lines;
        this.positionGroup = positionGroup;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void start() {
        positionGroup.playerPositions()
                .toList()
                .forEach(playerPosition -> start(playerPosition));
    }

    private void start(Position playerPosition) {
        lines.stream()
                .map(line -> line.direction(playerPosition.index()))
                .forEach(playerPosition::change);
        playerPosition.fix();
    }

    public int totalLines() {
        return lines.size();
    }

    public List<Result> results(String value) {
        if (value.equals(ALL_RESULT)) {
            return positionGroup.resultAll();
        }
        return List.of(positionGroup.result(new Name(value)));
    }

    public int maxNameSize() {
        return positionGroup.maxNameSize();
    }

    public Positions playerPositions() {
        return positionGroup.playerPositions();
    }

    public Positions resultPositions() {
        return positionGroup.resultPositions();
    }
}
