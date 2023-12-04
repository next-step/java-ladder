package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RealLadder implements Iterable<RealLine> {
    private final List<RealLine> lines;

    public RealLadder(List<RealLine> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    public RealLadder(Players players, Height height, LineStrategy lineStrategy) {
        List<RealLine> lines = new ArrayList<>();
        for (int i = 0; i < height.height(); i++) {
            RealLine realLadder = createLine(players.size(), lineStrategy);
            lines.add(realLadder);
        }

        this.lines = lines;
    }

    private static RealLine createLine(int personCount, LineStrategy lineStrategy) {
        return lineStrategy.createRealLine(personCount);
    }

    public void validate(List<RealLine> lines) {
        checkLinesSizeIsValid(lines);
    }

    public void checkLinesSizeIsValid(List<RealLine> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("라인은 최소 1개 이상이어야 합니다.");
        }
    }

    public RealLine startLine() {
        return this.lines.get(0);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }

    @Override
    public Iterator<RealLine> iterator() {
        return this.lines.iterator();
    }

    public int move(int index) {
        for (RealLine realLine : lines) {
            index = realLine.move(index);
        }

        return index;
    }
}
