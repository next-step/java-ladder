package ladder.dto;

public class LadderRequest {
    private final String userNames;
    private final String rewards;
    private final int height;

    public LadderRequest(String userNames, String rewards, int height) {
        this.userNames = userNames;
        this.rewards = rewards;
        this.height = height;
    }

    public String getUserNames() {
        return userNames;
    }

    public String getRewards() {
        return rewards;
    }

    public int getHeight() {
        return height;
    }
}
