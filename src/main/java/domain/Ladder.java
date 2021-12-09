package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public int finalPoint(int startPoint) {
        int currentPoint = startPoint;
        for (LadderLine ladderLine : ladderLines) {
            currentPoint = ladderLine.move(currentPoint);
        }

        return currentPoint;
    }

    public static Ladder of(int sizeOfPerson, int height) {
        List<LadderLine> ladderLines = new ArrayList<>();

        IntStream.range(0, height)
                .forEach(i -> ladderLines.add(LadderLine.init(sizeOfPerson)));

        return new Ladder(ladderLines);
    }

    public int height() {
        return ladderLines.size();
    }

    public List<Boolean> line(int level) {
        return ladderLines.get(level).line();
    }
}
