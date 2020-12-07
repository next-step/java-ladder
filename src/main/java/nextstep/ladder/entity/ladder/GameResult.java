package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.User;

import java.util.Objects;

public class GameResult {

    private String value;
    private User user;

    public GameResult(String value) {
        this.value = value;
    }

    public void map(User user) {
        this.user = user;
    }

    public String getValue() {
        return value;
    }

    public User getUser() {
        return user;
    }

    public boolean isResultOf(User user) {
        return Objects.equals(this.user, user);
    }

}
