package nextstep.ladders.domain;

import nextstep.ladders.domain.strategy.DirectionGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLines {

    private final List<LadderLine> ladderLines;

    public LadderLines(final List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public LadderLines(final DirectionGenerator directionGenerator, final int height, final int numberOfPeople) {
        this(LadderLine.toList(directionGenerator, height, numberOfPeople));
    }

    public int move(int index) {
        for (LadderLine ladderLine : ladderLines) {
            index = ladderLine.move(index);
        }
        return index;
    }

    public List<LadderLine> elements() {
        return Collections.unmodifiableList(ladderLines);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLines ladderLines1 = (LadderLines) o;
        return Objects.equals(ladderLines, ladderLines1.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
