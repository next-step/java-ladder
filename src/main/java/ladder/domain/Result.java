package ladder.domain;

import java.util.Objects;

public class Result {

    private final User user;
    private final Reward reward;

    public Result(User user, Reward reward) {
        this.user = user;
        this.reward = reward;
    }

    public User getUser() {
        return user;
    }

    public Reward getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return user.equals(result.user) && reward.equals(result.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, reward);
    }
}
