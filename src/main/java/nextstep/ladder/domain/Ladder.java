package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public static Ladder of(int row, int height) {
        List<Line> tempLines = new ArrayList<>();
        for (int count = 0; count < row; row++) {
            tempLines.add(new Line(height));
        }
        return new Ladder(tempLines);
    }

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

}
