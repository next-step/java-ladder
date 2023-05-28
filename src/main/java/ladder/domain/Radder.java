package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Radder {
    public static final int MIN_WIDTH = 2;
    public static final int MIN_HEIGHT = 1;
    private List<Line> lines;

    public Radder(int width, int height) {
        validateInput(width, height);

        lines = Stream.generate(() -> new Line(width))
                .limit(height)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void validateInput(int width, int height) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException("사다리 폭은 " + MIN_WIDTH + " 이상이어야 합니다.");
        }

        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_HEIGHT + " 이상이어야 합니다.");
        }
    }


    public List<Line> getLines() {
        return lines;
    }
}
