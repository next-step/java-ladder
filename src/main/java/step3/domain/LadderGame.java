package step3.domain;

import java.util.List;

public class LadderGame {
    private final Names names;
    private final Lines lines;

    public LadderGame(Names names, int height) {
        Height.validateHeight(height);
        this.names = names;
        this.lines = new Lines(names.size(), height);
    }

    public Result getEachResult(Name name, Results results) {
        return results.get(lines.getResultIndex(names.indexOf(name)));
    }

    public List<Name> getNames() {
        return names.getNames();
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
