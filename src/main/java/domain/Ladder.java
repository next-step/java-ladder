package domain;

public class Ladder {

    private final Lines lines;
    private final Players players;

    public Ladder(Lines lines, Players players) {
        this.lines = lines;
        this.players = players;
    }

    public static Ladder of(Players players, Height height) {
        Lines lines = Lines.of(players.totalNumber(), height);
        return new Ladder(lines, players);
    }
}
