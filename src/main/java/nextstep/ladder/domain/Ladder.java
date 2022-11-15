package nextstep.ladder.domain;

import java.util.List;

public class Ladder {

    private final Users users;
    private final Lines lines;

    public Ladder(Users users, Lines lines) {
        this.users = users;
        this.lines = lines;
    }

    public List<User> getUsers() {
        return users.getUsers();
    }

    public List<Line> getLines() {
        return lines.getLines();
    }
}
