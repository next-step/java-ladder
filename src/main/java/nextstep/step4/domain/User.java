package nextstep.step4.domain;

import java.util.Objects;

public class User {
    private String userName;
    private String result;

    public User(String userName, String result) {
        this.userName = userName;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName) &&
                result.equals(user.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, result);
    }
}
