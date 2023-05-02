package nextstep.ladder.domain.line;

import nextstep.ladder.domain.util.LadderUtil;

import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int participantsCount) {
        this.points = LadderUtil.makeLadderLine(participantsCount);
    }

    public List<Boolean> getLine() {
        return this.points;
    }
}
