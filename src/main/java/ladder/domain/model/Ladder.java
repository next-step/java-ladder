package ladder.domain.model;

public class Ladder {
    private Players players;
    private Lines lines;

    public Ladder(Players players, Lines lines) {
        this.players = new Players(players.getPlayers());
        this.lines = new Lines(lines.getLines());
    }

    public void playGame() {
        players.move(lines);
    }
}
