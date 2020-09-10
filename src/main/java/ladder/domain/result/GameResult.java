package ladder.domain.result;

import lombok.Builder;

public class GameResult {
    private final String name;
    private final String reward;

    @Builder
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
