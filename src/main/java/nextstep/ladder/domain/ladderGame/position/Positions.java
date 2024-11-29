package nextstep.ladder.domain.ladderGame.position;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.point.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Positions {
    private final List<Position> positions;

    public Positions() {
        this(new ArrayList<>());
    }

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    public void add(List<Line> lines, int playerPosition) {
        int indexPosition = toIndex(playerPosition);
        Position position = new Position(indexPosition);
        positions.add(position);

        for (int i = 0; i < lines.size(); i++) {
            Point currentPoint = lines.get(i).getPoints().get(indexPosition);

            position = position.move(currentPoint);
            positions.add(position);
            indexPosition = position.getPosition();
        }
    }

    private int toIndex(int playerPosition) {
        return playerPosition - 1;
    }

    public List<Position> getPositions() {
        return Collections.unmodifiableList(positions);
    }
}
