package camp.nextstep.edu.rebellion.domain.reward;

public class RewardResult {
    private final String name;
    private final String reward;

    public RewardResult(String name, String reward) {
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
