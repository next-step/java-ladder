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
}
