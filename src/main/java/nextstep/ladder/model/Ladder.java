package nextstep.ladder.model;

import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final Integer height;

    public Ladder(List<Line> lines, Integer height) {
        this.lines = lines;
        this.height = height;
    }
}
