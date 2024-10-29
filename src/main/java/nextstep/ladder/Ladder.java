package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String VALIDATE_HEIGHT = "높이는 1이상이어야 합니다.";
    private static final String VALIDATE_COUNT_PERSON = "참여자는 2명 이상이어야 합니다.";
    private final List<Line> lines;

    public Ladder(int height, int countOfPerson) {
        validateLadder(height, countOfPerson);
        this.lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    private void validateLadder(int height, int countOfPerson) {
        if (height < 1) {
            throw new IllegalArgumentException(VALIDATE_HEIGHT);
        }
        if (countOfPerson < 2) {
            throw new IllegalArgumentException(VALIDATE_COUNT_PERSON);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
