package ladder.domain;

import java.util.List;

public class LadderFactory {
    private final Names names;
    private final Lines lines;

    public LadderFactory(String namesText, int height) {
        this(namesText, height, new RandomLineGenerator());
    }

    public LadderFactory(String namesText, int height, LineGenerator lineGenerator) {
        this.names = new Names(namesText);
        this.lines = new Lines(height, names.connectSize(), lineGenerator);
    }

    public List<List<Boolean>> getLadder() {
        return lines.getList();
    }

    public List<String> getNames() {
        return names.getAll();
    }
}
