package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lineList;

    public Ladder(List<Line> list) {
        lineList = list;
    }

    public static Ladder createLadder(int width, int ladderHeight) {
        List<Line> tmpList = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            tmpList.add(new Line(width));
        }

        return new Ladder(tmpList);
    }

    public List<Line> getLines() {
        return lineList;
    }
}
