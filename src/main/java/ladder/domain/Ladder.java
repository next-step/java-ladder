package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    public static final int MIN_HEIGHT = 1;
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        validateHeight(lines.size());

        this.lines = lines;
    }

    public static Ladder of(int width, int height) {
        validateHeight(height);

        return new Ladder(Stream.generate(() -> Line.createLineWithWidth(width))
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

    public int getLastPosition(int position) {
        return lines.stream()
                .reduce(position, (x, line) -> line.getNextPosition(x), (x, y) -> y);
    }
}
