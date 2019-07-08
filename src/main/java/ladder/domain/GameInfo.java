package ladder.domain;

public class GameInfo {

    private Players players;
    private Prizes prizes;

    private GameInfo(Players players, Prizes prizes) {
        this.players = players;
        this.prizes = prizes;
    }

    public static GameInfo of(Players players, Prizes prizes) {
        return new GameInfo(players, prizes);
    }
}
