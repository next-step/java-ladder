package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final String WIDTH_REQUIRED = "가로라인이 존재해야합니다.";
    private static final int MINIMUM_USERS = 2;
    private static final String USER_SHOULD_MORE_THAN_TWO = "사람수는 2명 이상 이어야 합니다.";
    private final List<Direction> directions;

    public Line(final List<Direction> directions) {
        this.directions = directions;
    }

    public Line(final int userCounts, DirectionGenerator directionGenerator) {
        validateSize(userCounts);
        this.directions = new ArrayList<>(validateLines(directionGenerator.generate()));
    }

    private void validateSize(int users) {
        if (users < MINIMUM_USERS) {
            throw new IllegalArgumentException(USER_SHOULD_MORE_THAN_TWO);
        }
    }

    private List<Direction> validateLines(List<Direction> widthLines) {
        if (widthLines.isEmpty()) {
            throw new IllegalArgumentException(WIDTH_REQUIRED);
        }
        return new ArrayList<>(widthLines);
    }

    public List<Direction> getDirections() {
        return new ArrayList<>(directions);
    }

    public int move(int position){
        return directions.get(position).move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(getDirections(), line.getDirections());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDirections());
    }
}
