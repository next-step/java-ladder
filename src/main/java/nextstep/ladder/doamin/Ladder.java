package nextstep.ladder.doamin;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.utils.Preconditions;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        Preconditions.checkEmpty(lines, "lines는 필수값입니다.");

        this.lines = lines;
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    // 불변으로 리턴 하자
    @GetterForUI
    public List<Line> getLines() {
        return lines;
    }
}
