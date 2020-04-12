package ladder.domain;

import ladder.dto.GameInfo;

import java.util.List;

public class Ladder {
    private final int height;
//    private final List<Line> lines;

    public Ladder(GameInfo gameInfo, int height) {
        this.height = height;
//        this.lines = lines;
    }
}
