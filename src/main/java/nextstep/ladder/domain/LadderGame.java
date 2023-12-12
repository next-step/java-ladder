package nextstep.ladder.domain;

public class LadderGame {
    private Names names;
    private Lines lines;

    public LadderGame(Names names) {
        this.names = names;
    }

    public Names getNames() {
        return names;
    }

    public Lines getLines() {
        return lines;
    }
}
