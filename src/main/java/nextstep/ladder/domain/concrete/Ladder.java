package nextstep.ladder.domain.concrete;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.strategy.LadderStrategy;

import java.util.Collections;
import java.util.List;

public class Ladder implements LadderStrategy {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);

        this.lines = lines;
    }

    public void validate(List<Line> lines) {
        checkLinesSizeIsValid(lines);
    }

    public void checkLinesSizeIsValid(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("라인은 최소 1개 이상이어야 합니다.");
        }
    }

    @Override
    public Position move(Position position) {
        for (Line line : lines) {
            position = line.move(position);
        }

        return position;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(this.lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
