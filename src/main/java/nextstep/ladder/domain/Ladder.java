package nextstep.ladder.domain;

public class Ladder {
    private final Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder of(LineGenerationStrategy lineGenerationStrategy, int countOfPerson,
        int height) {
        final Lines lines = Lines.of(lineGenerationStrategy, countOfPerson, height);
        return new Ladder(lines);
    }

    public Lines getLines() {
        return lines;
    }
}
