package ladder.domain;

public class LadderInfo {
    private final int playerCount;
    private final int height;

    public static LadderInfo of(String users, int height) {
        return new LadderInfo(Users.of(users).size(), height);
    }

    public LadderInfo(int playerCount, int height) {
        this.playerCount = playerCount;
        this.height = height;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getHeight() {
        return height;
    }
}
