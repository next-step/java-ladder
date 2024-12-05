package nextstep.ladder.domain;

public class PointFactory {

    public static Point generatePoint(int lineIdx, Line line) {
        if (lineIdx == 0) {
            return Point.first(line.getLine(lineIdx));
        }

        if (lineIdx == line.size()) {
            return Point.last(line.getLine(lineIdx - 1));
        }

        return Point.middle(line.getLine(lineIdx - 1), line.getLine(lineIdx));
    }
}
