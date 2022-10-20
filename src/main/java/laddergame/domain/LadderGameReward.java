package laddergame.domain;

import java.util.Objects;

public class LadderGameReward {

    public static final int MAX_LENGTH = 5;

    private final String name;

    public LadderGameReward(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("사다리 게임 결과는 null이거나 공백일 수 없습니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("사다리 게임 결과는 최대 5자까지 부여할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameReward that = (LadderGameReward) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

}
