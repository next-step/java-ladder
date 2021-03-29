package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        IntStream.range(0, height)
                .forEach(index -> ladder.add(new Line(countOfPerson)));
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public void drawLine(DrawStrategy drawStrategy) {
        ladder.forEach(line -> line.draw(drawStrategy));
    }

    public int result(int startIndex) {
        int resultIndex = startIndex;
        for (Line line : ladder) {
            resultIndex += resultOneLine(line, resultIndex);
        }

        return resultIndex;
    }

    private int resultOneLine(Line line, int index) {
        if (line.getPoints().get(index)) {
            return  1;
        }
        if (index != 0 && line.getPoints().get(index - 1)) {
            return  - 1;
        }
        return 0;
    }
}
