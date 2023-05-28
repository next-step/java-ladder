package step4.domain;

import java.util.List;

public class Line {
    private final List<Boolean> line;

    public Line(int countOfPerson) {
        this(countOfPerson, DefaultLineBuilder.getInstance());
    }

    public Line(int countOfPerson, LineBuilder lineBuilder) {
        line = lineBuilder.buildLine(countOfPerson);
    }

    public Line(List<Boolean> line) {
        this.line = line;
    }

    public int nextPosition(int initPosition) {
        return initPosition + nowPoint(initPosition).nextDirection().value;
    }

    private Point nowPoint(int initPosition) {
        if (isFirstPosition(initPosition)) {
            return Point.first(line.get(initPosition));
        }
        if (isLastPosition(initPosition)) {
            return Point.last(line.get(initPosition - 1));
        }
        return new Point(line.get(initPosition - 1), line.get(initPosition));
    }

    private boolean isFirstPosition(int initPosition) {
        return initPosition == 0;
    }

    private boolean isLastPosition(int initPosition) {
        return initPosition == line.size();
    }
}
