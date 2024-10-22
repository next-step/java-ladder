package nextstep.ladder.domain;

public class LadderGame {
    private final Users players;
    private final Ladder ladder;

    public LadderGame(Users players, PositiveNumber height) {
        this.players = players;
        this.ladder = new Ladder(new PositiveNumber(players.size()), height);
    }

    public Users getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
