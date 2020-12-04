package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private static final String INPUT_HEIGHT_ERROR = "사다리의 높이는 최소 1개 이상이어야 합니다.";
    private static final int MIN_HEIGHT = 1;
    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int countOfPerson, int height) {
        return new Lines(IntStream.range(0,heightValidationCheck(height))
                .mapToObj(i -> new Line(countOfPerson))
                .collect(Collectors.toList()));
    }

    private static int heightValidationCheck(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(INPUT_HEIGHT_ERROR);
        }
        return height;
    }

    public List<Line> getLines() {
        return lines;
    }
}
