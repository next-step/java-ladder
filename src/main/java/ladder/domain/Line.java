package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public Line(int countOfPerson) {
        this.points = new ArrayList<>();
        generateLine(countOfPerson);
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public int lineCount() {
        return points.size();
    }

    boolean hasHorizontalLine(int index) {
        return points.get(index).hasHorizontalLine();
    }

    private void generateLine(int countOfPerson) {
        boolean previousPoint = BooleanGenerator.pick();
        firstPoint(previousPoint);
        for(int i = 1; i < countOfPerson - 1; i++) {
            boolean currentPoint = BooleanGenerator.pick(previousPoint);
            points.add(new Point(previousPoint, currentPoint));
            previousPoint = currentPoint;
        }
        lastPoint(previousPoint);

    }

    public int move(int lineIndex) {
        int result = 0;
        if(points.get(lineIndex).isLeft()) {
            result = -1;
        }
        if(points.get(lineIndex).isRight()) {
            result = 1;
        }
        if(points.get(lineIndex).isCenter()) {
            result = 0;
        }

        return result;
    }

    private void lastPoint(boolean point) {
        points.add(new Point(point, false));
    }

    private void firstPoint(boolean point) {
        points.add(new Point(false, point));
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(EMPTY_LINE);
        for(int i = 0; i < points.size(); i++) {
            stringBuffer.append(VERTICAL_LINE);
            stringBuffer.append(printHorizontalLine(this, i));
        }
        return stringBuffer.toString();
    }

    private String printHorizontalLine(Line line, int index) {
        if(line.hasHorizontalLine(index)) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_LINE;
    }
}
