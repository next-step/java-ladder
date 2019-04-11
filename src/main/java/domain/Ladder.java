package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int ladderHeight) {
        IntStream.range(0, ladderHeight)
                .forEach(i -> this.lines.add(new Line(countOfPerson)));
    }

    public int calcStartIndex(int playerPoint) {
        int startPoint = playerPoint;
        for (int i = 0; i < this.lines.size(); i++) {
            Line line = this.lines.get(i);
            line.movePoint(startPoint);
            startPoint = line.movePoint(startPoint);
        }
        return startPoint;
    }

    @Override
    public String toString() {
        String result = "";
        for (Line line : this.lines) {
            result += line.printLine() + "\n";
        }
        return result;
    }
}
