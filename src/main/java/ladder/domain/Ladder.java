package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MINIMUM_USERS = 2;
    private static final String MAXIMUM_HEIGHT_ERROR = "사다리 높이는 1이상 입력해야합니다";
    private static final String MAXIMUM_USER_ERROR = "사용자가 두명 이상이어야합니다.";

    private List<Line> lines = new ArrayList<>();
    private int height;

    public Ladder(int height, Users users) {
        validate(height, users.size());
        this.lines = generateLines(height, users.size());
    }

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }


    private void validate(int height, int personCount) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(MAXIMUM_HEIGHT_ERROR);
        }

        if (personCount < MINIMUM_USERS) {
            throw new IllegalArgumentException(MAXIMUM_USER_ERROR);
        }
    }

    private List<Line> generateLines(int height, int personCount) {
        List<Line> generatedLines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            generatedLines.add(new Line(personCount));
        }
        return new ArrayList<>(generatedLines);
    }

    public int move(int position) {
        for (Line line : lines) {
            position += line.move(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
