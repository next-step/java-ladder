package ladder.model;

import java.util.Objects;

public class Reward {

    private String result;

    public Reward(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(result, reward.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
