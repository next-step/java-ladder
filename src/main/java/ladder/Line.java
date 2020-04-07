package ladder;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Line {
    private List<Boolean> points;

    public Line(int countOfPerson) {
        points = generateLine(countOfPerson);
    }

    private List<Boolean> generateLine(int countOfPerson) {
        return Stream
                .generate(() -> false)
                .limit(countOfPerson)
                .collect(toList());
    }

    public int getWidth() {
        return points.size();
    }
}
