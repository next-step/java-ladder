package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MINIMUM_USERS = 2;
    private static final String MAXIMUM_HEIGHT_ERROR = "사다리 높이는 1이상 입력해야합니다";
    private static final String MAXIMUM_USER_ERROR = "사용자가 두명 이상이어야합니다.";
    private static final String USER_GOALS_COUNTS_SHOULD_SAME = "사용자와 사다리결과 숫자는 같아야합니다.";

    private List<Line> lines = new ArrayList<>();
    private int height;

    public Ladder(int height, DirectionGenerator directionsGenerator) {
       validate(height);
        this.lines = generateLines(height, directionsGenerator);
    }

    public Map<String, String> play(Users users, LadderGoals ladderGoals) {
        Map<String, String> result = new HashMap<>();
        if (users.size() != ladderGoals.size()) {
            throw new IllegalArgumentException(USER_GOALS_COUNTS_SHOULD_SAME);
        }

        for (User player : users.getUsers()) {
            int position = player.getPosition();
            for (Line line : lines) {
                position += line.move(position);
            }
            result.put(player.getName(), ladderGoals.getResult(position));
        }

        return result;
    }

    private void validate(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(MAXIMUM_HEIGHT_ERROR);
        }
    }

    private List<Line> generateLines(int height, DirectionGenerator directionGenerator) {
        List<Line> generatedLines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            generatedLines.add(new Line(directionGenerator.generate()));
        }
        return new ArrayList<>(generatedLines);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
