package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int countOfPlayer, int countOfResult) {
        validateSize(countOfPlayer, countOfResult);
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPlayer))
                .collect(Collectors.toList());
    }

    private void validateSize(int countOfPlayer, int countOfResult) {
        if (countOfPlayer != countOfResult) {
            throw new IllegalArgumentException(
                    String.format("참여할 사람과 실행 결과의 갯수가 동일해야 합니다. Player : %d, Result : %d", countOfPlayer, countOfResult)
            );
        }
    }

    public int findResultIdx(int playerIdx) {
        int idx = playerIdx;
        for (Line line : lines) {
            idx = line.move(idx);
        }
        return idx;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
