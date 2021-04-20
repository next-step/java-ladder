package nextstep.model;

public class OnlineLadder extends Ladder {
    private final Lines lines;
    private final Players players;

    public OnlineLadder(int maxVertical, int countOfPerson, String[] names) {
        this.lines = new Lines(maxVertical, countOfPerson);
        this.players = new Players(names);
        this.lineMarkAll();
    }

    public void lineMarkAll() {
        this.lines.initMark();
        this.lines.markWithoutFirst();
    }

    public Points points(int row) {
        return this.lines.points(row);
    }

    public Players players() {
        return players;
    }

    public int start(Player whoWinner) {
        int playerIndex = this.filter(whoWinner);
        if (playerIndex < 0) {
            throw new IllegalArgumentException("No user");
        }
        return this.lines.start(playerIndex);
    }

    public int filter(Player playerName) {
        return this.players.filter(playerName);
    }
}
