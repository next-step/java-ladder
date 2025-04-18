package ladder.domain;

import java.util.List;

public class Ladder {
    private final Names names;
    private final Lines lines;

    public Ladder(List<String> names, int height) {
        this(names, height, new RandomRungGenerator());
    }

    public Ladder(List<String> names, int height, RungGenerator rungGenerator) {
        this.names = new Names(names);
        this.lines = new Lines(height, this.names.connectSize(), rungGenerator);
    }

    public Lines getLines() {
        return lines;
    }

    public Names getNames() {
        return names;
    }
}
