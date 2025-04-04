package nextstep.ladder;

public class Ladder {

    private final Lines lines;
    private final Names names;

    private Ladder(Lines lines, Names names) {
        this.lines = lines;
        this.names = names;
    }

    public static Ladder getRandomly(LadderHeight ladderHeight, Names names) {
        Lines lines = Lines.generateRandomly(ladderHeight, names.getListNames().size());
        return new Ladder(lines, names);
    }

    public Lines getLines() {
        return lines;
    }

    public Names getNames() {
        return names;
    }
}
