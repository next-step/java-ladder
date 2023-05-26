package step3.domain;

import java.util.List;

public class LadderGame {
    private final Names names;
    private final Height height;
    private final Lines lines;

    public LadderGame(List<String> names, int height) {
        this.names = new Names(names);
        this.height = new Height(height);
        this.lines = new Lines(names.size(), height);
    }

    public List<Name> getNames() {
        return names.getNames();
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
