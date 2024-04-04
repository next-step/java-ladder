package domain;

public class GameBoard {

    private final Lines lines;
    private final Players players;

    public GameBoard(Lines lines, Players players) {
        this.lines = lines;
        this.players = players;
    }

    public static GameBoard of(Players players, Height height, BridgeCreationStrategy strategy) {
        Lines lines = Lines.of(players.totalNumber(), height, strategy);
        return new GameBoard(lines, players);
    }

    public void display(LadderVisitor visitor) {
        players.accept(visitor);
        lines.accept(visitor);
    }
}
