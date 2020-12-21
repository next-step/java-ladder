package nextstep.step2.VO;

public class User {
    private final String name;
    private final Position startPosition;

    public User(String name, Position position) {
        this.name = name;
        this.startPosition = position;
    }

    public String getName() {
        return name;
    }
}
