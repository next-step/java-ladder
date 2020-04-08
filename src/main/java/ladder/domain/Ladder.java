package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MINNIMUM_USERS = 2;
    private static final String MAXIMUM_HEIGHT_ERROR = "사다리 높이는 1이상 입력해야합니다";
    private static final String MAXIMUM_USER_ERROR = "사용자가 두명 이상이어야합니다.";

    private List<Line> lines = new ArrayList<>();
    private int height;

    public Ladder(int height, int personCount) {
        validate(height, personCount);
        this.lines = generateLines(height, personCount);
    }

    private void validate(int height, int personCount) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(MAXIMUM_HEIGHT_ERROR);
        }

        if (personCount < MINNIMUM_USERS) {
            throw new IllegalArgumentException(MAXIMUM_USER_ERROR);
        }
    }

    private List<Line> generateLines(int height, int personCount) {
        List<Line> generatedLines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator(personCount);
        for (int i = 0; i < height; i++) {
            generatedLines.add(new Line(lineGenerator.generate()));
        }
        return new ArrayList<>(generatedLines);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
