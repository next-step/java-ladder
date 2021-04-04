package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson)
            .forEach((index) -> points.add(new Point()));
    }
}
