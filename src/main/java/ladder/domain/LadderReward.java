package ladder.domain;

public class LadderReward {

    private final String reward;

    public LadderReward(String reward) {
        this.reward = reward;
    }

    public String getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        return reward;
    }
}
