package nextstep.ladder.model;

public final class UserResult {

    private final User user;
    private final LadderResult result;

    public UserResult(User user, LadderResult result) {
        this.user = user;
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public LadderResult getResult() {
        return result;
    }
}
