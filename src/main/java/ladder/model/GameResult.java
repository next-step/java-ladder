package ladder.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(name, that.name) && Objects.equals(reward, that.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, reward);
    }
}
