package nextstep.ladder.domain;

public class LadderClimber {
    private final Lines lines;
    private final Players players;

    public LadderClimber(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }
}
