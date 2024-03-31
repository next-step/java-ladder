package nextstep.step4.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int MIN_COUNT = 2;

    private final int countOfPerson;
    private final List<Line> lines;

    public Ladder(int countOfPerson, List<Line> lines) {
        validate(countOfPerson, lines);

        this.countOfPerson = countOfPerson;
        this.lines = lines;
    }

    private void validate(int countOfPerson, List<Line> lines) {
        if (countOfPerson < MIN_COUNT) {
            throw new IllegalArgumentException("최소 인원은 " + MIN_COUNT + "명 입니다");
        }

        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("라인 정보가 비어있습니다");
        }
    }

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

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Ladder ladder = (Ladder) other;
        return countOfPerson == ladder.countOfPerson && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfPerson, lines);
    }
}
