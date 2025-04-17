package ladder.domain;

import java.util.List;

public class Ladder {
    private final Names names;
    private final Lines lines;

    public Ladder(List<String> names, int height) {
        this(names, height, new RandomLineGenerator());
    }

    public Ladder(List<String> names, int height, LineGenerator lineGenerator) {
        this.names = new Names(names);
        this.lines = new Lines(height, this.names.connectSize(), lineGenerator);
    }

    public Lines getLadder() {
        return lines;
    }

    public Names getNames() {
        return names;
    }
}
