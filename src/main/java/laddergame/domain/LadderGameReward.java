package laddergame.domain;

import java.util.Objects;

public class LadderGameReward {

    public static final int MAX_LENGTH = 5;

    private final String name;

    public LadderGameReward(String name) {
        this.name = name;
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
