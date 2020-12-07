package ladder.domain.line;

import java.util.stream.IntStream;
import ladder.domain.Position;
import ladder.domain.point.PointGenerator;
import ladder.domain.user.Users;

public class LineGenerator {

    private static final int SECOND_INDEX = 1;

    private final PointGenerator pointGenerator;

    public LineGenerator() {
        this.pointGenerator = new PointGenerator();
    }

    public LineGenerator(PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    public Line generateLine(Users users) {
        int lastIndexOfLine = users.getUsersCount() - 1;
        Line newLine = new Line();

        newLine.addPoint(pointGenerator.generateLineStartPoint());

        IntStream.range(SECOND_INDEX, lastIndexOfLine)
            .mapToObj(index -> pointGenerator.generateNextPoint(newLine.getLastPoint(), new Position(index)))
            .forEach(newLine::addPoint);

        newLine.addPoint(pointGenerator.generateLineEndPoint(newLine.getLastPoint(), new Position(lastIndexOfLine)));

        return newLine;
    }
}
