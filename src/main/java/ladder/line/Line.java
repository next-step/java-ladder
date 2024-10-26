package ladder.line;

import ladder.Cross;
import ladder.Direction;
import ladder.Point;
import ladder.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Cross> crosses = new ArrayList<>();

    public Line(List<Cross> crosses) {
        this.crosses = crosses;
    }

    public Line(int countOfPerson, LineGenerateStrategy lineGenerateStrategy) {
        boolean isPrevLineConnected = false;

        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean currentLineConnection = !isPrevLineConnected && lineGenerateStrategy.generate();
            crosses.add(new Cross(new Position(i), Point.first(isPrevLineConnected).next(currentLineConnection)));
            isPrevLineConnected = currentLineConnection;
        }

        crosses.add(new Cross(new Position(countOfPerson - 1), Point.first(isPrevLineConnected).last()));
    }

    public static Line from(List<Boolean> points) {
        List<Cross> crossList = new ArrayList<>();
        boolean prev = false;
        for (int i = 0; i < points.size(); i++) {
            crossList.add(new Cross(new Position(i), Point.first(prev).next(points.get(i))));
        }
        return new Line(crossList);
    }

    public Position move(int position) {
        return move(new Position(position));
    }

    public Position move(Position position) {
        return crosses.get(position.getPosition()).move();
    }

    public List<Cross> getCrosses() {
        return crosses;
    }

    public Direction getDirection(int index){
        return crosses.get(index).getDirection();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(crosses, line.crosses);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(crosses);
    }
}
