package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private final Lines lines;

    public Ladder(int countOfPlayer, int height) {
        this(new CountOfPlayer(countOfPlayer), new Height(height));
    }

    public Ladder(CountOfPlayer countOfPlayer, Height height) {
        this(new Lines(countOfPlayer, height));
    }

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public int height() {
        return lines.size();
    }

    public List<List<Boolean>> linesConnection() {
        return lines.linesConnection();
    }
}
