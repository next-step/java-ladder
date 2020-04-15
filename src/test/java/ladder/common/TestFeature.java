package ladder.common;

import ladder.ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class TestFeature {

    public static List<Line> generateLines(boolean... booleans) {
        List<Line> stubLines = new ArrayList<>();
        for (int i = 0; i < booleans.length; i++) {
            stubLines.add(Line.of(i, booleans[i]));
        }
        return stubLines;
    }
}
