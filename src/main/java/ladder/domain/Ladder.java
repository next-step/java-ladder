package ladder.domain;

import java.util.List;

public class Ladder {
    private final Names names;
    private final Lines lines;
    private final Prizes prizes;

    public Ladder(List<String> names, int height, List<String> prizes) {
        this(names, height, new RandomRungGenerator(), prizes);
    }

    public Ladder(List<String> names, int height, RungGenerator rungGenerator, List<String> prizes) {
        validateSameSize(names, prizes);
        this.names = new Names(names);
        this.lines = new Lines(height, this.names.connectSize(), rungGenerator);
        this.prizes = new Prizes(prizes);
    }

    private void validateSameSize(List<String> names, List<String> results) {
        if (names.size() != results.size())
            throw new IllegalArgumentException("The size of names and results do not match");
    }

    public Lines getLines() {
        return lines;
    }

    public Names getNames() {
        return names;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
