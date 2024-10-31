package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String VALIDATE_HEIGHT = "높이는 1이상이어야 합니다.";
    private static final String VALIDATE_COUNT_PERSON = "참여자는 2명 이상이어야 합니다.";
    private static final int MIN_HEIGHT = 1;
    private static final int MIN_PERSON = 2;
    private final List<Line> lines;


    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(int height, int countOfPerson) {
        validateLadder(height, countOfPerson);
        List<Line> lines = initLines(height, countOfPerson);
        return new Ladder(lines);
    }

    private static void validateLadder(int height, int countOfPerson) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(VALIDATE_HEIGHT);
        }
        if (countOfPerson < MIN_PERSON) {
            throw new IllegalArgumentException(VALIDATE_COUNT_PERSON);
        }
    }

    private static List<Line> initLines(int height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.create(countOfPerson));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        StringBuilder ladderOutput = new StringBuilder();
        for (Line line : lines) {
            ladderOutput.append(line.toString()).append("\n");
        }
        return ladderOutput.toString();
    }
}
