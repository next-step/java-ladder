package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    public static final int MAX_HEIGHT = 1;
    public static final Random random = new Random();
    private List<Line> lines;


    public Ladder(int rows, int columns) {
        this.lines = makeLines(rows, columns);
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private List<Line> makeLines(int rows, int columns) {
        if (columns < MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리는 높이가 %d 이상이여야 합니다", MAX_HEIGHT));
        }
        return Stream.generate(() -> new Line(rows, random))
                .limit(columns)
                .collect(Collectors.toList());
    }

    public List<Line> lines() {
        return lines;
    }
}
