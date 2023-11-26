package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    public static List<Line> createLadder(int personCount, int height, LineStrategy ladderStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createLine(personCount, ladderStrategy));
        }

        return lines;
    }

    public static Line createLine(int personCount, LineStrategy ladderStrategy) {
        return ladderStrategy.createLine(personCount);
    }
}
