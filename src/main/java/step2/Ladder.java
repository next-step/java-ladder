package step2;

import java.util.List;

public class Ladder {
    public static final String VERTICAL_LINE = "|";
    public static final String HORIZON_LINE = "-----";
    private final List<Line> ladder;

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }
}
