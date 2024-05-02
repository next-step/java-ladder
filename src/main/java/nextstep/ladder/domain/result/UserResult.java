package nextstep.ladder.domain.result;

import java.util.Objects;
import nextstep.ladder.domain.user.User;

public class UserResult{
    private final User user;
    private final String result;

    private UserResult(User user, String result) {
        this.user = user;
        this.result = result;
    }

    public String getUserName() {
        return user.getName();
    }

    public String getResult() {
        return result;
    }

    public static UserResult of(String user, String result){
        return new UserResult(User.of(user), result);
    }

    public static UserResult of(User user, String result){
        return new UserResult(user, result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserResult that = (UserResult) o;
        return Objects.equals(user, that.user) && Objects.equals(result,
            that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, result);
    }

    @Override
    public String toString() {
        return "UserResult{" +
            "user=" + user +
            ", result='" + result + '\'' +
            '}';
    }
}
