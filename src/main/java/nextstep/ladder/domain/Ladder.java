package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);

        this.lines = lines;
    }

    public Ladder(Players players, Height height, LineStrategy lineStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.height(); i++) {
            Line line = createLine(players.size(), lineStrategy);
            lines.add(line);
        }

        this.lines = lines;
    }

    private static Line createLine(int personCount, LineStrategy lineStrategy) {
        return lineStrategy.createLine(personCount);
    }

    public void validate(List<Line> lines) {
        checkLinesSizeIsValid(lines);
    }

    public void checkLinesSizeIsValid(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("라인은 최소 1개 이상이어야 합니다.");
        }
    }

    public int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }

        return index;
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
