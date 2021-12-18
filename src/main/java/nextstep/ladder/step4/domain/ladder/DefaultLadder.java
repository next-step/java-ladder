package nextstep.ladder.step4.domain.ladder;

import java.util.List;
import nextstep.ladder.step4.domain.ladder.engine.Ladder;

public class DefaultLadder implements Ladder {

    private final List<DefaultLine> lines;

    public DefaultLadder(List<DefaultLine> lines) {
        valid(lines);
        this.lines = lines;
    }

    private void valid(List<DefaultLine> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리의 Line 값이 존재하지 않습니다.");
        }
    }

    @Override
    public LadderResult play() {
        return null;
    }

}
