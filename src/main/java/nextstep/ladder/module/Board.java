package nextstep.ladder.module;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final NameList names;
    private final Height height;
    private List<Line> lines;

    public Board(NameList names, Height height) {
        this.names = names;
        this.height = height;
    }

    public NameList names() {
        return names;
    }

    public List<Line> lines() {
        return lines;
    }

    public void createLines() {
        lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(names.size()));
        }
    }

    public void createLadders() {
        lines.forEach(Line::createLadders);
    }
}
