package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_WIDTH = 1;
    private static final int MIN_HEIGHT = 1;
    public static final String INVALID_WIDTH_HEIGHT_MESSAGE = "width와 height는 양수여야 합니다.";

    private final List<Line> lines;

    public Ladder(Names names, int height) {
        this(names.count() * 2 - 1, height);
    }

    public Ladder(int width, int height) {
        if (width < MIN_WIDTH || height < MIN_HEIGHT) {
            throw new IllegalArgumentException(INVALID_WIDTH_HEIGHT_MESSAGE);
        }

        this.lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }
    }

    public int height() {
        return lines.size();
    }

    public int width() {
        return lines.get(0).width();
    }

}
