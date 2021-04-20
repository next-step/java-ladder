package nextstep.ladder.entity.ladder;

public class GameResult {
    private final String name;
    private final String reward;

    public String getName() {
        return name;
    }

    public String getReward() {
        return reward;
    }

    public GameResult(String name, String reward) {
        this.name = name;
        this.reward = reward;
    }
}
