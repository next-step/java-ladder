package ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        points = generateLine(countOfPerson);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int getWidth() {
        return points.size();
    }

    private List<Boolean> generateLine(int countOfPerson) {
        return Stream
                .generate(() -> true)
                .limit(countOfPerson)
                .collect(toList());
    }
}
