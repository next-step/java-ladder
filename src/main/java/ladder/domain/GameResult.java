package ladder.domain;

import java.util.Objects;
import static ladder.util.StringUtil.isBlank;

public class GameResult {

    private static final String NOT_FOUND_USER = "유저이름에 Null 또는 공백이 올 수 없습니다.";

    private final User user;
    private final String reward;

    private GameResult(User user, String reward) {
        this.user = user;
        this.reward = reward;
    }

    public static GameResult of(User user, String reward) {
        return new GameResult(user,reward);
    }

    public boolean contains(String userName) {
        if (isBlank(userName)) {
            throw new NullPointerException(NOT_FOUND_USER);
        }
        return user.contains(userName);
    }

    public User getUser() {
        return user;
    }

    public String getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(user, that.user) && Objects.equals(reward, that.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, reward);
    }
}
