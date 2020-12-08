package my.project.domain;


public class Reward {
    public static final String INPUT_REWARD_ALERT = "실행 결과를 확인해주십시요.";

    private String reward;

    public Reward(String reward) {
        validate(reward);
        this.reward = reward;
    }

    private void validate(String reward) {
        if (isBlank(reward)) {
            throw new IllegalArgumentException(INPUT_REWARD_ALERT);
        }
    }

    private boolean isBlank(String reward) {
        return reward == null || reward.trim().isEmpty();
    }

    public String getReward() {
        return String.format("%-" + User.MAX_LENGTH + "s", reward);
    }
}
