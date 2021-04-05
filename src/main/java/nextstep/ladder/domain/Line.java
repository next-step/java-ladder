package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final String PLAYER_COUNT_VALIDATE_MESSAGE = "참여자는 2명 이상이여야 합니다";
    private static final int MINIMUM_PLAYER_BOUND = 2;
    private static final String LINE_DELIMITER = "";
    private static final String END_LINE = "|";

    private final List<Point> points;

    public Line(int countOfPerson) {
        validatePersonCount(countOfPerson);
        this.points = createPoints(countOfPerson);
    }

    private void validatePersonCount(int countOfPerson) {
        if (countOfPerson < MINIMUM_PLAYER_BOUND) {
            throw new IllegalArgumentException(PLAYER_COUNT_VALIDATE_MESSAGE);
        }
    }

    private List<Point> createPoints(int countOfPerson) {
        return PointGenerator.generate(countOfPerson);
    }

    public int pointSize() {
        return points.size();
    }

    public String drawLine() {
        List<String> lines = new ArrayList<>();
        for (int i = 1; i < points.size(); i++) {
            lines.add(points.get(i).draw());
        }
        lines.add(END_LINE);
        return String.join(LINE_DELIMITER, lines);
    }
}
