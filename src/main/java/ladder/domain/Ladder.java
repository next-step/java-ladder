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
            resultIndex += line.result(resultIndex);
        }

        return resultIndex;
    }
}
