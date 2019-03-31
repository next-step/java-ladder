package ladder.dto;

public class Result {
    private String reward;

    public Result(String reward) {
        this.reward = reward;
    }

    public int getRewardLength() {
        return reward.length();
    }

    @Override
    public String toString() {
        return reward;
    }
}
