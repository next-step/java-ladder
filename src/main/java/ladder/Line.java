package ladder;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Line {
    public static final int ONE_LINE_LENGTH = 5;

    private List<Boolean> points;

    public Line(int countOfPerson) {
        points = generateLine(countOfPerson);
    }

    private List<Boolean> generateLine(int countOfPerson) {
        return Stream
                .generate(this::generateOneLine)
                .limit(countOfPerson - 1)
                .flatMap(x -> x.stream())
                .collect(toList());
    }

    private List<Boolean> generateOneLine() {
        return Stream
                .generate(() -> true)
                .limit(ONE_LINE_LENGTH)
                .collect(toList());
    }

    public int getWidth() {
        return points.size();
    }
}
