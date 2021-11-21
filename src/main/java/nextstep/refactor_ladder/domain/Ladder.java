package nextstep.refactor_ladder.domain;

import nextstep.ladder.annotations.GetterForUI;
import nextstep.ladder.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
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

    public int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    @GetterForUI
    public List<Line> getLines() {
        return Collections.unmodifiableList(new ArrayList<>(lines));
    }
}
