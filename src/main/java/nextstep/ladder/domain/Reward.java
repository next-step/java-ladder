package nextstep.ladder.domain;

public class Reward {
    private final String reward;

    public Reward(String reward) {
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }

    @Override public String toString() {
        return reward;
    }
}
