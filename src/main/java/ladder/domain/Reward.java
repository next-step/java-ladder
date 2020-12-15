package ladder.domain;

import ladder.ladderexceptions.InvalidRewardNameException;

import java.util.Objects;

public class Reward {

    private final String name;

    public Reward(String reward) {
        validateName(reward);
        this.name = reward;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new InvalidRewardNameException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(this.name, reward.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
