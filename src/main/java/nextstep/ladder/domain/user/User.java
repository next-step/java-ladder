package nextstep.ladder.domain.user;


import nextstep.ladder.domain.ladder.Position;

public class User {

    private final UserName name;
    private final Position position;

    public User(String name, int position) {
        this.name = new UserName(name);
        this.position = new Position(position);
    }

    public UserName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
