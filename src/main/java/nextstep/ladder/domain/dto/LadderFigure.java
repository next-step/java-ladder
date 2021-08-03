package nextstep.ladder.domain.dto;

import java.util.List;

public class LadderFigure {
    private final List<Boolean> lines;

    private LadderFigure(List<Boolean> lines) {
        this.lines = lines;
    }

    public static LadderFigure of(List<Boolean> lines) {
        return new LadderFigure(lines);
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
