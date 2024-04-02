package nextstep.step2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int width, PointGenerator pointGenerator) {
        this.lines = Stream.concat(
                Stream.iterate(new Line(height, pointGenerator), prev -> new Line(height, prev, pointGenerator))
                        .limit(width - 1),
                Stream.of(Line.generateEndLine(height))
        ).collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int move(Position position) {
        int endXPosition = lines.size();
        int endYPosition = lines.isEmpty() ? 0 : lines.get(0).getPoints().size();

        while (position.getY() < endYPosition) {
            position = moveHorizontally(position, endXPosition);
            position = position.moveVertically();
        }

        return position.getX();
    }

    private Position moveHorizontally(Position position, int endXPosition) {
        int currentX = position.getX();
        boolean canMoveLeft = currentX > 0 && lines.get(currentX - 1).connectLine(position.getY());
        boolean canMoveRight = currentX < endXPosition - 1 && lines.get(currentX).connectLine(position.getY());

        if (canMoveLeft) {
            return position.moveLeft();
        }
        if (canMoveRight) {
            return position.moveRight();
        }
        return position;
    }
}
