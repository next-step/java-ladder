package step2.model;

import java.util.Objects;

public class GameResult {
    private final User user;
    private final Result result;

    public GameResult(User user, Result result) {
        this.user = user;
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public Result getResult() {
        return result;
    }

    public String getUserName() {
        return user.getName();
    }

    public String getGameResult() {
        return result.getResult();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(user, that.user) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, result);
    }
}
