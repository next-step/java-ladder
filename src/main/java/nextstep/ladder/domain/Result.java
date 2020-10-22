package nextstep.ladder.domain;

public class Result {
    private final Reward reward;
    private String username;

    private Result(String username, Reward reward) {
        this.username = username;
        this.reward = reward;
    }

    public static Result of(String username, Reward resultRaw) {
        return new Result(username, resultRaw);
    }

    public Reward getReward() {
        return reward;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
