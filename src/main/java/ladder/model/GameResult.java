package ladder.model;

public class GameResult {
    private final String name;
    private final String reward;

    public GameResult(String name, String reward) {
        this.name = name;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public String getReward() {
        return reward;
    }
}
