package ladder.domain;

import ladder.stretagy.PointBuildStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int totalLine, int joinMembersCount, PointBuildStrategy pointBuildStrategy) {
        validate(totalLine);

        this.lines = IntStream.range(0, totalLine)
                .mapToObj(i -> Line.createLine(joinMembersCount, pointBuildStrategy))
                .collect(Collectors.toList());
    }

    public static Ladder createLadder(int totalLine, Gamers gamers, PointBuildStrategy pointBuildStrategy) {
        Ladder ladder = new Ladder(totalLine, gamers.countGamers(), pointBuildStrategy);
        ladder.ladderMove(gamers);

        return ladder;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    private void ladderMove(Gamers gamers) {
        List<Position> endPositions = new ArrayList<>();

        for (int i = 0; i < gamers.countGamers(); i++) {
            Position startPosition = new Position(i);
            Position endPosition = findEndPoint(startPosition);

            endPositions.add(endPosition);
        }

        gamers.recordEndPosition(endPositions);
    }

    private Position findEndPoint(Position position) {
        for (Line line : lines) {
            position = position.move(line);
        }
        return position;
    }

    private void validate(int totalLine) {
        if (totalLine <= 0) {
            throw new IllegalArgumentException("최대 사다리 높이는 0개 이하로 생성할 수 없습니다.");
        }
    }
}
