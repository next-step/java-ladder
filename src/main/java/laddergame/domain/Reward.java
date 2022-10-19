package laddergame.domain;

import java.util.Objects;

public class Reward {
    private final String value;

    public Reward(String input) {
        validateReward(input);
        this.value = input;
    }

    private void validateReward(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 입력될 수 없습니다.");
        }
        if (input.trim().length() > 5) {
            throw new IllegalArgumentException("실행 결과는 최대 5글자까지 입력할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(value, reward.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
