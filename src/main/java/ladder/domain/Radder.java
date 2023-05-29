package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Radder {
    public static final int MIN_HEIGHT = 1;
    private List<Line> lines;

    public Radder(List<Line> lines) {
        validateHeight(lines.size());

        this.lines = lines;
    }

    public static Radder of(int width, int height) {
        validateHeight(height);

        return new Radder(Stream.generate(() -> new Line(width))
                .limit(height)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    private static void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_HEIGHT + " 이상이어야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
