package my.project.step3.domain;


import java.util.regex.Pattern;

public class Reward {
    public static final String INPUT_REWARD_ALERT = "실행 결과를 확인해주십시요.(최대 " + User.MAX_LENGTH + "자)";

    private final String reward;

    public Reward(String reward) {
        validate(reward);
        this.reward = reward;
    }

    private void validate(String reward) {
        if (!Pattern.matches(User.USER_PATTERN, reward)) {
            throw new IllegalArgumentException(INPUT_REWARD_ALERT);
        }
    }

    public String get() {
        return String.format("%-" + User.MAX_LENGTH + "s", reward);
    }
}
