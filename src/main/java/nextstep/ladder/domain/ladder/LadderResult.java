package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.User;

import java.util.Objects;

public class LadderResult {

    private final User user;
    private final Reward reward;

    public LadderResult(User user) {
        this(user, null);
    }

    public LadderResult(User user, Reward reward) {
        this.user = user;
        this.reward = reward;
    }

    public User getUser() {
        return user;
    }

    public Reward getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        return "LadderResult{" +
                "user=" + user +
                ", reward=" + reward +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(getUser(), that.getUser()) && Objects.equals(getReward(), that.getReward());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getReward());
    }
}
