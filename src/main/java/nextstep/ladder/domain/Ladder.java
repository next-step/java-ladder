package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int height;
    private final List<Line> lines;

    public Ladder(int height, int countOfPerson) {
        this(height, IntStream.range(0, height)
                .mapToObj((i) -> new Line(countOfPerson))
                .collect(Collectors.toList()));
    }

    public Ladder(int height, List<Line> lines) {
        validateHeight(height, lines);
        this.height = height;
        this.lines= lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return height;
    }

    private static void validateHeight(int height, List<Line> lines) {
        if (height != lines.size()) {
            throw new IllegalArgumentException("입력한 높이와 Line의 갯수가 다릅니다.");
        }
    }
}
