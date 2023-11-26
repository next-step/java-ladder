package nextstep.ladder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder implements Iterable<Line> {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    public Ladder(int personCount, int height, LineStrategy ladderFactory) {
        this.lines = LadderFactory.createLadder(personCount, height, ladderFactory);
    }

    public void validate(List<Line> lines) {
        checkLinesSizeIsValid(lines);
    }

    public void checkLinesSizeIsValid(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("라인은 최소 1개 이상이어야 합니다.");
        }

        for (Line line : lines) {
            line.validate(line.points());
        }
    }

    public List<Line> lines() {
        return this.lines;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }

    @Override
    public Iterator<Line> iterator() {
        return this.lines.iterator();
    }
}
