package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String MIN_LADDER_HEIGHT_EXCEPTION_MESSAGE = "사다리 높이는 1이상 이여야 합니다.";

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfPerson, int ladderHeight, BooleanGenerator booleanGenerator) {
        validateLadder(countOfPerson, ladderHeight);
        List<Line> newLadder = createLadder(countOfPerson, ladderHeight, booleanGenerator);
        return new Ladder(newLadder);
    }

    private static List<Line> createLadder(int countOfPerson, int ladderHeight, BooleanGenerator booleanGenerator) {
        List<Line> newLadder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            Line line = Line.of(countOfPerson, booleanGenerator);
            newLadder.add(line);
        }
        return newLadder;
    }

    private static void validateLadder(int countOfPerson, int ladderHeight) {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException(Ladder.MIN_LADDER_HEIGHT_EXCEPTION_MESSAGE);
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLadderRowSize() {
        return lines.size();
    }

    public int move(int index) {
        int currentPosition = index;
        for (Line line : lines) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }
}
