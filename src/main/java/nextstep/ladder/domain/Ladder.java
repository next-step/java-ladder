package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private Users users;
    private Rows points;

    public Ladder(Users users, Rows points) {
        this.users = users;
        this.points = points;
    }

    public static Ladder of(List<String> names, int height, PointGenerator generator) {
        return new Ladder(Users.of(names), Rows.of(names.size(), height, generator));
    }

    public Users getUsers() {
        return users;
    }

    public Rows getPoints() {
        return points;
    }
}
