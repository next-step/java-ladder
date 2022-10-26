package ladder.domain.ladder.ladderline;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderLines {

    private final List<LadderLine> ladderLines;
    private static final String LADDERLINES_DELIMITER = "\n";

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLines that = (LadderLines) o;
        return Objects.equals(ladderLines, that.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }

    @Override
    public String toString() {
        return ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.joining(LADDERLINES_DELIMITER));
    }
}
