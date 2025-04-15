package ladder.domain;

import java.util.List;

public class LadderFactory {
    private final Names names;
    private final Lines lines;

    public LadderFactory(List<String> names, int height) {
        this(names, height, new RandomLineGenerator());
    }

    public LadderFactory(List<String> names, int height, LineGenerator lineGenerator) {
        this.names = new Names(names);
        this.lines = new Lines(height, this.names.connectSize(), lineGenerator);
    }

    public List<List<Boolean>> getLadder() {
        return lines.getList();
    }

    public List<String> getNames() {
        return names.getAll();
    }
}
