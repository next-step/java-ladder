package nextstep.ladder.domain;

public class PlayerStatus {

    private final LadderPoints ladderPoints;
    private Location location;

    public PlayerStatus(LadderPoints ladderPoints, int x) {
        this(ladderPoints,
            new Location(ladderPoints.getLadderLength(), ladderPoints.getColumnCount(), x, 0));
    }

    public PlayerStatus(LadderPoints ladderPoints, Location location) {
        this.ladderPoints = ladderPoints;
        this.location = location;
    }

    public void go() {
        location = location.next(this.ladderPoints);
    }

    public boolean isMovable() {
        return location.isMovable();
    }


    public LadderPoints getLadderPoints() {
        return ladderPoints;
    }

    public Location getLocation() {
        return location;
    }
}
