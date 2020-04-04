package ladder.domain;

public class LadderGame {

    private final Players players;
    private final Lines lines;

    public LadderGame(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public LadderGame(Players players, int height) {
        LadderGenerator ladderGenerator =
                new LadderGenerator(players.getPlayersCount(), height);
        Lines lines = ladderGenerator.generateLines();

        this.players = players;
        this.lines = lines;
    }

    public Lines getLines() {
        return lines;
    }
}
