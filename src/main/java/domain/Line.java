package domain;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    public static final String BAR = "|";
    public static final String LINE_LOOKS = "-";
    public static final String LINE_LOOKS_NONE = " ";

    private final List<Point> points;

    Line(List<Point> points) {
        if (isInvalid(points)) {
            System.err.println(points);
            throw new IllegalArgumentException();
        }

        this.points = points;
    }

    public int positionAfterMove(int position) {
        return points.get(position).move();
    }

    public String paint(int spacingLetterLength) {
        final String lineLooks = StringUtils.repeat(LINE_LOOKS, spacingLetterLength) + BAR;
        final String noneLooks = StringUtils.repeat(LINE_LOOKS_NONE, spacingLetterLength) + BAR;

        return BAR +
                IntStream.range(0, points.size() - 1)
                .mapToObj(i -> points.get(i).hasDirection(Direction.RIGHT) ? lineLooks : noneLooks)
                .collect(Collectors.joining());
    }

    public int size() {
        return points.size();
    }

    private boolean isValid(List<Point> points) {
        final int countOfPoints = points.size();

        if (points.stream().filter(p -> p.hasDirection(Direction.NONE)).count() == countOfPoints) {
            return false;
        }

        if (points.stream().filter(p -> p.hasDirection(Direction.RIGHT)).count() == countOfPoints) {
            return false;
        }

        return true;
    }

    private boolean isInvalid(List<Point> points) {
        return !isValid(points);
    }

    public boolean isValid() {
        return isValid(this.points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
