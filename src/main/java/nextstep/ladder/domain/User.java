package nextstep.ladder.domain;

import java.util.List;

public class User {

    private UserName userName;

    private Position position;

    public User(String name, int position) {
        this.userName = new UserName(name);
        this.position = new Position(position);
    }

    public int findLastPosition(Ladder ladder) {
        return position.findLastPosition(ladder);
    }

    public String getResult(List<String> results) {
        return position.getResult(results);
    }

    @Override
    public String toString() {
        return userName.toString();
    }
}
