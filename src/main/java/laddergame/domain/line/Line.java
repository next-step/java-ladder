package laddergame.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import laddergame.domain.ladder.Depth;
import laddergame.domain.person.Participants;

public class Line {

    private List<LineStatus> points;

    private static final int MIN_PERSON = 1;

    public Line(List<LineStatus> lines) {
        this.points = lines;
    }

    public Line(int countOfPeople, ConnectionStrategy connectionStrategy) {
        validateCountOfParticipants(countOfPeople);
        int initialCapacity = countOfPeople - 1;
        init(connectionStrategy, initialCapacity);
    }

    public List<LineStatus> getPoints() {
        return points;
    }

    public static List<Line> list(
        Depth depth,
        Participants participants,
        ConnectionStrategy connectionStrategy
    ) {
        List<Line> lines = new ArrayList<>(depth.size());
        IntStream.range(0, depth.size())
            .forEach(e -> lines.add(new Line(participants.getCount(), connectionStrategy)));
        return lines;
    }

    private void validateCountOfParticipants(final int countOfPeople) {
        if (countOfPeople <= MIN_PERSON) {
            throw new IllegalArgumentException("참여 인원은 두 명 이상이어야 합니다.");
        }
    }

    private void init(final ConnectionStrategy connectionStrategy, final int initialCapacity) {
        this.points = connectionStrategy.getConnection(initialCapacity);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Line line = (Line) o;
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
