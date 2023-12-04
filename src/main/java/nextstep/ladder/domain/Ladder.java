package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.LineStrategy;

import java.util.List;

public class Ladder {
    private final Lines lines;

    public Ladder(List<Line> lines) {
        validate(lines);

        this.lines = new Lines(lines);
    }

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public Ladder(Players players, Height height, LineStrategy lineStrategy) {
        Lines lines = new Lines();
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

    public Lines lines() {
        return this.lines;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
