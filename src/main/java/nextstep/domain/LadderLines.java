package nextstep.domain;

import java.util.Collections;
import java.util.List;

public class LadderLines {
    private final List<LadderLine> ladderLines;

    public LadderLines(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public List<LadderLine> getLadderLines() {
        return Collections.unmodifiableList(this.ladderLines);
    }

}
