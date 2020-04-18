package ladder;

public class LadderInfo {
    private final int playerCount;
    private final DirectionCreator directionCreator;

    public LadderInfo(int playerCount, DirectionCreator directionCreator) {
        this.playerCount = playerCount;
        this.directionCreator = directionCreator;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public DirectionCreator getDirectionCreator() {
        return directionCreator;
    }
}
