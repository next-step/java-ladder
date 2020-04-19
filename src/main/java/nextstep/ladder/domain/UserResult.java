package nextstep.ladder.domain;

import java.util.Objects;

public class UserResult {
    private User user;
    private Result result;

    public UserResult(String userName) {
        this.user = new User(userName);
    }

    public UserResult(User user, Result result) {
        this.user = user;
        this.result = result;
    }

    public String getName() {
        return user.getName();
    }

    public String getResult() {
        return result.getResult();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof UserResult)) { return false; }
        final UserResult that = (UserResult) o;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
