package nextstep.labber;

public class User {
    public static final int NAME_SPACE_LENGTH = 5;

    private final String name;

    public User(String name) {
        if (name.length() > NAME_SPACE_LENGTH ) {
            throw new IllegalArgumentException("The name cannot exceed five characters.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
