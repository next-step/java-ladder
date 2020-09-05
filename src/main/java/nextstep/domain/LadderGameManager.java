package nextstep.domain;

import java.util.Collections;
import java.util.List;

public class LadderGameManager {

    private final List<Line> lines;

    public LadderGameManager(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
