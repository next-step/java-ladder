package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lineList = new ArrayList();

    public Ladder(int personNum, int height) {
        IntStream.range(0, height).forEach(i -> lineList.add(new Line(personNum)));
    }

    public int ladderHeight () {
        return lineList.size();
    }

    public Line getLine(int heightIdx) {
        return lineList.get(heightIdx);
    }
}
