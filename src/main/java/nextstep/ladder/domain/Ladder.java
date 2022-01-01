package nextstep.ladder.domain;

/**
 * @author han
 */
public class Ladder {
    private final Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder of(Lines lines) {
        return new Ladder(lines);
    }

    public Lines getLines() {
        return lines;
    }
}
