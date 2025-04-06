package nextstep.ladder.module;

import java.util.List;

public class Board {
    private final List<Line> lines;
    
    public Board(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> value() {
        return lines;
    }
    
}
