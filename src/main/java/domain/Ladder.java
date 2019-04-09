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

    public void print() {
        this.lines.forEach(line -> System.out.println(line.printLine()));
    }

    public int calcStartIndex(int playerIndex) {
        int startIndex = playerIndex;
        for (int i = 0; i < this.lines.size(); i++) {
            this.lines.get(i).location(this.lines.get(i), startIndex);
            startIndex = this.lines.get(i).location(this.lines.get(i), startIndex);
        }
        return startIndex;
    }

}
