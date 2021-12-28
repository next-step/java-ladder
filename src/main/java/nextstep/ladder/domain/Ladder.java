package nextstep.ladder.domain;

/**
 * @author han
 */
public class Ladder {
    private final Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder from(Users users, Height height) {
        return new Ladder(Lines.of(users, height));
    }

    public Lines getLines() {
        return lines;
    }
}
