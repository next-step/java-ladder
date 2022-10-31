package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    public static final String HEIGTH_EXCEPTION = "사다리의 높이는 1이상이어야 합니다.";
    private final int height;
    public final List<Line> lines;

    public Ladder(int height) {
        validateHeight(height);
        this.height = height;
        this.lines = new ArrayList<>(height);
    }

    private void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(HEIGTH_EXCEPTION);
        }
    }

    public void createLadder(int userCounts) {
        for (int i = 0; i < this.height; i++) {
            this.lines.add(new Line(userCounts));
        }
    }

}
