package nextstep.step2.domain;

import java.util.Objects;

public class Result {
    private final Integer position;
    private final String reward;

    public Result(int position, String reward) {
        this.position = position;
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }

    public boolean equalsPosition(final int position) {
        return this.position == position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Result result = (Result) o;
        return Objects.equals(position, result.position) &&
            Objects.equals(reward, result.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, reward);
    }

    @Override
    public String toString() {
        return reward;
    }
}
