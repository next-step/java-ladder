package ladder.domain.line;

import ladder.domain.Position;
import ladder.domain.point.Point;
import ladder.domain.point.PointGenerator;
import ladder.domain.user.Users;

public class LineGenerator {

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

        for (int i = 1; i < lastIndexOfLine; i++) {
            Point newPoint = pointGenerator.generateNextPoint(newLine.getLastPoint(), new Position(i));
            newLine.addPoint(newPoint);
        }
        newLine.addPoint(pointGenerator.generateLineEndPoint(newLine.getLastPoint(), new Position(lastIndexOfLine)));

        return newLine;
    }
}
