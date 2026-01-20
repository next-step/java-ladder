package nextstep.ladder.domain;

public class Ladder {
    private final Names names;
    private final Lines lines;

    public Ladder(String input, int height) {
        this(new Names(input), new Lines(height, new Names(input).size()));
    }

    public Ladder(Names names, Lines lines) {
        this.names = names;
        this.lines = lines;
    }

    public Names getNames() {
        return names;
    }

    public Lines getLines() {
        return lines;
    }
}
