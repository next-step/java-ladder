package ladder.domain.ladder.ladderline;

import ladder.domain.ladder.Ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderLine {

    private final List<Ladder> ladders;
    private final String LADDER_LINE_START_TEXT = "    ";

    public LadderLine(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(ladders, that.ladders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladders);
    }

    @Override
    public String toString() {
        return (LADDER_LINE_START_TEXT + ladders.stream()
                .map(Ladder::toString)
                .collect(Collectors.joining()))
                .stripTrailing();
    }
}
