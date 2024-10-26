package ladder.line;

import ladder.line.move.LadderPosition;
import ladder.line.move.Point;
import ladder.line.move.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<LadderPosition> ladderPositions = new ArrayList<>();

    public Line(int countOfPerson, LineGenerateStrategy lineGenerateStrategy) {
        boolean isPrevLineConnected = false;

        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean currentLineConnection = !isPrevLineConnected && lineGenerateStrategy.generate();
            ladderPositions.add(new LadderPosition(new Position(i), Point.first(isPrevLineConnected).next(currentLineConnection)));
            isPrevLineConnected = currentLineConnection;
        }

        ladderPositions.add(new LadderPosition(new Position(countOfPerson - 1), Point.first(isPrevLineConnected).last()));
    }

    public Position move(int position) {
        return move(new Position(position));
    }

    public Position move(Position position) {
        return ladderPositions.get(position.getPosition()).move();
    }

    public List<LadderPosition> getCrosses() {
        return ladderPositions;
    }

    public int getCrossesSize() {
        return ladderPositions.size();
    }

    public boolean isConnected(int index) {
        return ladderPositions.get(index).isConnected();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(ladderPositions, line.ladderPositions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ladderPositions);
    }
}
