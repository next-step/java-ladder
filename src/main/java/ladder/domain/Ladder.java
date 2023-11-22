package ladder.domain;

import ladder.stretagy.PointBuildStrategy;

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

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    public int ladderMove(int startPosition) {
        for (Line line : lines) {
            Direction direction = line.move(startPosition);
            startPosition = direction.move(startPosition);
        }
        return startPosition;
    }


    private void validate(int totalLine) {
        if (totalLine <= 0) {
            throw new IllegalArgumentException("최대 사다리 높이는 0개 이하로 생성할 수 없습니다.");
        }
    }
}
