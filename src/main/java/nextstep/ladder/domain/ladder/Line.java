package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.strategy.RandomStrategy;

import java.util.Objects;

public class Line {
    public static final String PARTICIPANTS_LIMIT_MESSAGE = "참가자는 2명 이상이어야 합니다.";
    public static final int MIN_PARTICIPANTS = 2;
    private final Points points;

    private Line(Points points) {
        this.points = points;
    }

    public static Line from(int numberOfParticipants) {
        if (numberOfParticipants < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException(PARTICIPANTS_LIMIT_MESSAGE);
        }

        return new Line(Points.of(numberOfParticipants, new RandomStrategy()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
