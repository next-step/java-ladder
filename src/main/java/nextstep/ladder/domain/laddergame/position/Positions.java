package nextstep.ladder.domain.laddergame.position;

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

    public Positions add(List<Line> lines, int playerPosition) {
        Position position = new Position(playerPosition);
        positions.add(position);

        for (int i = 0; i < lines.size(); i++) {
            Point currentPoint = lines.get(i).getPoints().get(playerPosition);

            position = position.move(currentPoint);
            positions.add(position);
            playerPosition = position.getPosition();
        }

        return new Positions(positions);
    }

    public List<Position> getPositions() {
        return Collections.unmodifiableList(positions);
    }

    public int getLastPosition() {
        return positions.get(positions.size() - 1).getPosition();
    }
}
