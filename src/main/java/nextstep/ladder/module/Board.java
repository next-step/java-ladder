package nextstep.ladder.module;

import java.util.List;

public class Board {
    private List<Line> lines;
    private NameList names;

    public Board(List<Line> lines, NameList names) {
        this.lines = lines;
        this.names = names;
    }

    public List<Line> lines() {
        return lines;
    }

    public NameList names() {
        return names;
    }
}
