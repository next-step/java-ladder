package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderLines {
    private final List<LadderLine> ladderLines;

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public int size() {
        return ladderLines.size();
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(ladderLines);
    }

    @Override
    public String toString() {
        return "    " + ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.joining("\n    "));
    }
}
