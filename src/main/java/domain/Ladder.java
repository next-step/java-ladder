package domain;

public class Ladder {

    private final Lines lines;
    private final Players players;

    public Ladder(Lines lines, Players players) {
        this.lines = lines;
        this.players = players;
    }

    public static Ladder of(Players players, Height height, BridgeCreationStrategy strategy) {
        Lines lines = Lines.of(players.totalNumber(), height, strategy);
        return new Ladder(lines, players);
    }

    public void display(LadderVisitor visitor) {
        players.accept(visitor);
        lines.accept(visitor);
    }
}
