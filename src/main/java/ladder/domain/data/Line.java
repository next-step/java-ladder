package ladder.domain.data;

import java.util.*;
import java.util.stream.Collectors;

import static ladder.domain.data.Ladder.INDENT;
import static ladder.domain.data.Name.NAME_SIZE;

public class Line {

    private final List<Point> points;

    public Line(String strings) {
        this(Arrays.stream(strings.split(""))
            .map(Direction::valueOfCharacter)
            .map(Point::new)
            .collect(Collectors.toList())
        );
    }

    public Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public int run(int index) {
        int leftIndex = 2 * index - 1;
        int rightIndex = 2 * index + 1;
        if (leftIndex >= 1) {
            index = left(index, leftIndex);
        }
        if (rightIndex < points.size()) {
            index = right(index, rightIndex);
        }
        return index;
    }

    private int left(int index, int leftIndex) {
        if (points.get(leftIndex).equalsHorizontal()) {
            index -= 1;
        }
        return index;
    }

    private int right(int index, int rightIndex) {
        if (points.get(rightIndex).equalsHorizontal()) {
            index += 1;
        }
        return index;
    }

    @Override
    public String toString() {
        return INDENT.repeat(NAME_SIZE) + points.stream()
            .map(Point::addIndent)
            .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Line line = (Line) object;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return points != null ? points.hashCode() : 0;
    }

}
