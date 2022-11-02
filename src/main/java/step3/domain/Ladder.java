package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String HEIGHT_EXCEPTION = "사다리의 높이는 1이상이어야 합니다.";

    private final int height;
    public final List<Line> lines;

    public Ladder(int height,int userCounts) {
        validateHeight(height);
        this.height = height;
        this.lines = createLadder(userCounts);
    }

    private void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(HEIGHT_EXCEPTION);
        }
    }

     private List<Line> createLadder(int userCounts) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < this.height; i++) {
            lines.add(new Line(userCounts));
        }
        return lines;
    }

}
