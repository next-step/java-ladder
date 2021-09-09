package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class User {

    private UserName userName;

    private Position position;

    public User(String name, int startPosition, int lastPosition) {
        this.userName = new UserName(name);
        this.position = new Position(startPosition, lastPosition);
    }

    public User(String name, int startPosition) {
        this.userName = new UserName(name);
        this.position = new Position(startPosition);
    }

    public User(String name) {
        this.userName = new UserName(name);
    }

    public int findLastPosition(Ladder ladder) {
        return position.findLastPosition(ladder);
    }

    public Result findUserResult(List<Result> results) {
        return position.findUserResult(results);
    }


    @Override
    public String toString() {
        return userName.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
