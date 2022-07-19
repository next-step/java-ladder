package ladder.domain.second;

import ladder.domain.ConnectingStrategy;
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class LadderLine implements LineCreator {
    private final int countOfLines;
    private final Positions positions;

    public LadderLine(int countOfLines) {
        this(countOfLines, new ArrayList<>());
    }

    LadderLine(int countOfLines, ConnectingStrategy connectingStrategy) {
        this(countOfLines, new ArrayList<>());
        connect(connectingStrategy);
    }

    public LadderLine(int countOfLines, List<Position> positions) {
        this(countOfLines, new Positions(positions));
    }

    public LadderLine(int countOfLines, Positions positions) {
        this.countOfLines = countOfLines;
        this.positions = positions;
    }

    public int move(int positionIndex) {
        return positions.get(positionIndex).move();
    }

    @Override
    public void connect(ConnectingStrategy connectingStrategy) {
        Position position = firstPosition(connectingStrategy);
        position = middlePosition(connectingStrategy, position);
        positions.add(position.last());
    }

    private Position firstPosition(ConnectingStrategy connectingStrategy) {
        Position position = Position.first(connectingStrategy.connectable());
        positions.add(position);
        return position;
    }

    private Position middlePosition(ConnectingStrategy connectingStrategy, Position position) {
        for (int i = 1; i < countOfLines; i++) {
           position = position.next(connectingStrategy);
           positions.add(position);
        }
        return position;
    }

    @Override
    public List<Boolean> getConnectingLines() {
        List<Boolean> lines = new ArrayList<>();
        for (Position position : positions.getPositionList()) {
            lines.add(position.movable());
        }
        lines.remove(lines.size() - 1);
        return lines;
    }
}