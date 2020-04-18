package ladder;

public class LadderInfo {
    private final int playerCount;
    private final DirectionGenerator directionGenerator;

    public LadderInfo(int playerCount, DirectionGenerator directionGenerator) {
        this.playerCount = playerCount;
        this.directionGenerator = directionGenerator;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public DirectionGenerator getDirectionGenerator() {
        return directionGenerator;
    }
}
