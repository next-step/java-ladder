package nextstep.refactoring.laddergame.engine.reward;

import java.util.Objects;

public class RewardString {

    private static final String BLANK_REWARD_STRING = "꽝";

    private final String string;

    private RewardString(String string) {
        this.string = string;
    }

    public static RewardString of(String string) {
        validate(string);
        return new RewardString(string);
    }

    private static void validate(String string) {
        if (!(string.chars().allMatch(Character::isDigit) || string.equals(BLANK_REWARD_STRING))) {
            throw new IllegalArgumentException("꽝 또는 숫자만 사용할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RewardString)) {
            return false;
        }
        RewardString that = (RewardString) o;
        return Objects.equals(string, that.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

    @Override
    public String toString() {
        return string;
    }
}
