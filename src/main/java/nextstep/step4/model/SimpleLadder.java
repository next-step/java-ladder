package nextstep.step4.model;

import nextstep.step4.api.Ladder;
import nextstep.step4.api.LadderResult;
import nextstep.step4.api.Line;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SimpleLadder implements Ladder {
    private final int countOfPerson;
    private final List<Line> lines;

    public SimpleLadder(int countOfPerson, List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("라인 정보가 비어있습니다");
        }

        this.countOfPerson = countOfPerson;
        this.lines = lines;
    }

    @Override
    public LadderResult play() {
        LadderResult ladderResult = new LadderResult();
        for (int i = 0; i < countOfPerson; i++) {
            ladderResult.put(i, endPoint(i));
        }

        return ladderResult;
    }

    private int endPoint(int position) {
        int result = position;

        for (Line line : lines) {
            result = line.move(result);
        }

        return result;
    }

    @Override
    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        SimpleLadder that = (SimpleLadder) other;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
