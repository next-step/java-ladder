package nextstep.ladder;

import java.util.Arrays;
import java.util.List;

public class Ladder {

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, Line... lines) {
        List<Line> lineList = Arrays.asList(lines);
        validateSize(height, lineList);
        return new Ladder(lineList);
    }

    private static void validateSize(int height, List<Line> lines) {
        if (lines.size() != height) {
            throw new IllegalArgumentException("사다리 높이와 일치하지 않습니다.");
        }
    }
}
