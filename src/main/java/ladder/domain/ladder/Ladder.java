package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lineList;

    public Ladder(List<Line> list) {
        lineList = list;
    }

    public static Ladder createLadder(int width, int height) {
        List<Line> lineList = createLines(width, height);

        return new Ladder(lineList);
    }

    private static List<Line> createLines(int width, int height) {
        List<Line> tmpList = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            tmpList.add(new Line(width));
        }
        return tmpList;
    }

    public List<Line> getLines() {
        return lineList;
    }
}
