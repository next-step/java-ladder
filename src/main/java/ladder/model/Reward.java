package ladder.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reward {
    private static final String DEFAULT_REWARD = "꽝";
    private static final Pattern pattern = Pattern.compile("^[1-9]\\d*$");

    private final String reward;

    public Reward(String reward) {
        validateReward(reward);
        this.reward = reward;
    }

    private void validateReward(String reward) {
        Matcher matcher = pattern.matcher(reward);
        if (!DEFAULT_REWARD.equals(reward) && !matcher.find()) {
            throw new IllegalArgumentException("적절하지 않은 게임 실행 결과입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reward reward1 = (Reward) o;

        return Objects.equals(reward, reward1.reward);
    }

    @Override
    public int hashCode() {
        return reward != null ? reward.hashCode() : 0;
    }

    public String getReward() {
        return this.reward;
    }
}
