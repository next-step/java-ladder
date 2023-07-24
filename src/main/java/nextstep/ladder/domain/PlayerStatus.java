package nextstep.ladder.domain;

public class PlayerStatus {

    private final PlayerName playerName;
    private final LadderPoints ladderPoints;
    private Location location;

    public PlayerStatus(PlayerName playerName, LadderPoints ladderPoints, int x) {
        this(playerName, ladderPoints,
            new Location(ladderPoints.getLadderLength(), ladderPoints.getColumnCount(), x, 0));
    }

    public PlayerStatus(PlayerName playerName, LadderPoints ladderPoints, Location location) {
        this.playerName = playerName;
        this.ladderPoints = ladderPoints;
        this.location = location;
    }

    public void go() {
        location = location.next(this.ladderPoints);
    }

    public boolean isMovable() {
        return location.isMovable();
    }

    public PlayerName getPlayerName() {
        return playerName;
    }

    public LadderPoints getLadderPoints() {
        return ladderPoints;
    }

    public Location getLocation() {
        return location;
    }
}
