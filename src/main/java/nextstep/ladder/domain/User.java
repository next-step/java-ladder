package nextstep.ladder.domain;

public class User {

    private static final int MIN_HEIGHT = 0;

    private final UserName name;
    private Position position;

    public User(final String name, final int x) {
        this.name = new UserName(name);
        this.position = new Position(x, MIN_HEIGHT);
    }

    public String name() {
        return name.getName();
    }
}
