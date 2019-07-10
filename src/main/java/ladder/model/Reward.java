package ladder.model;

public class Reward {
    public static final int MAX_LENGTH = 5;
    public static final String MESSAGE_OF_OUT_REWARD_LENGTH = "보상은 %d 글자를 넘을 수 없습니다.";

    private final String reward;

    public Reward(String reward) {
        if (reward.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(MESSAGE_OF_OUT_REWARD_LENGTH, MAX_LENGTH));
        }
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }
}
