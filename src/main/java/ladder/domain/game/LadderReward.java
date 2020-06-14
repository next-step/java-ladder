package ladder.domain.game;

public class LadderReward {
    private final String reward;

    private LadderReward(String reward) {
        validateReward(reward);
        this.reward = reward;
    }

    public static LadderReward inputReward(String reward) {
        return new LadderReward(reward);
    }

    private void validateReward(String reward) {
        if (reward == null || "".equals(reward.trim())) {
            throw new IllegalArgumentException("유요하지 않은 경품을 입력했습니다.");
        }
    }

    public String getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return "LadderReward{" +
                "reward='" + reward + '\'' +
                '}';
    }
}
