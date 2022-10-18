package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Players;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(List<Line> lines) {
        if (lines.size() < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_LADDER_HEIGHT + " 이상이어야 합니다.");
        }
    }

    public static Ladder create(int height, Players players, EnablePointStrategy strategy) {
        int countOfPlayer = players.count();

        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> Line.create(countOfPlayer, strategy))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public int destinationPosition(int startPosition) {
        int linePosition = 0;

        while (true) {
            Point point = findPoint(linePosition, startPosition);

            if (linePosition == lines.size() - 1) {
                return point.nextPosition();
            }

            startPosition = point.nextPosition();
            linePosition++;
        }
    }

    private Point findPoint(int linePosition, int pointPosition) {
        return lines.get(linePosition)
                .findPoint(pointPosition);
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
}
