package ladder.domain;

public class User {
    private final UserName name;

    private final HorizontalPosition position;


    private User(UserName userName, HorizontalPosition position) {
        this.name = userName;
        this.position = position;
    }

    public static User withNameAndPosition(UserName userName, HorizontalPosition position) {
        return new User(userName, position);
    }

    public UserName getName() {
        return name;
    }

    public boolean isSameName(UserName name) {
        return this.name.equals(name);
    }

    public HorizontalPosition getPosition() {
        return new HorizontalPosition(position.getPosition());
    }

}
