package nextstep.ladder.domain;

public class User {

    private final UserName name;
    private Position position;

    public User(final String name, final Position position) {
        this.name = new UserName(name);
        this.position = position;
    }

    public String name() {
        return name.getName();
    }

    public boolean isMatchName(final String userName) {
        return name.isMatchName(userName);
    }

    public Position currentPosition() {
        return position;
    }

    public void assignResultPosition(Position position) {
        this.position = position;
    }

}
