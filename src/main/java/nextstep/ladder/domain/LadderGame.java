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

    public String getLadderAsString() {
        StringBuilder builder = new StringBuilder();
        ladder.getMapAsString().forEach(row ->
            builder.append(row).append("|").append("\n")
        );
        return builder.toString();
    }
}
