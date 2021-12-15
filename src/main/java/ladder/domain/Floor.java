package ladder.domain;

import ladder.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Floor {
    private final List<Boolean> lines = new ArrayList<>();
    private final MovingStrategy movingStrategy;

    public Floor(int countOfPillar, MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
        IntStream.range(0, countOfPillar).forEach(this::line);
    }

    private void line(int i) {
        // 앞에 선이 있었으면 추가 불가(무조건 false), 없었다면 랜덤하게 추가
        if (i == 0 || lines.get(i - 1)) {
            lines.add(false);
            return;
        }
        lines.add(movingStrategy.canMove());
    }

    public List<Boolean> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    // 왼쪽: -1 오른쪽 : + 1
    public int whichDirection(int position) {
        // position == 0 인 경우는 없음 section은 1부터
        int nextPosition = position;
        if (lines.get(position - 1)) {
            nextPosition -= 1;
        }
        if (position != lines.size() && lines.get(position)) {
            nextPosition += 1;
        }
        return nextPosition;
    }
}
