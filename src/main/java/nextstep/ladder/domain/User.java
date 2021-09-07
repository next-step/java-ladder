package nextstep.ladder.domain;

import java.util.List;

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

    public int findLastPosition(Ladder ladder) {
        return position.findLastPosition(ladder);
    }

    public Result findUserResult(List<Result> results) {
        return position.findUserResult(results);
    }

    public boolean isSameName(String name) {
        return userName.isSameName(name);
    }

    @Override
    public String toString() {
        return userName.toString();
    }

}
