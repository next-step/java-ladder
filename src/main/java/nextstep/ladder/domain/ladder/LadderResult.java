package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.User;

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
}
