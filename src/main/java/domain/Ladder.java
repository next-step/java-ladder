package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<LadderLine> lines = new ArrayList<>();

    public Ladder(int countOfPerson, Level level) {
        IntStream.range(0, level.getHeight())
                 .forEach(i -> this.lines.add(LadderLine.init(countOfPerson, level)));
    }

    public int calcStartIndex(int playerPoint) {
        int startPoint = playerPoint;
        for (int i = 0; i < this.lines.size(); i++) {
            LadderLine line = this.lines.get(i);
            line.movePoint(startPoint);
            startPoint = line.movePoint(startPoint);
        }
        return startPoint;
    }

    @Override
    public String toString() {
        String result = "";
        for (LadderLine line : this.lines) {
            result += line.printLine() + "\n";
        }
        return result;
    }
}
