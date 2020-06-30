package nextstep.ladder.domain;

public class User {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("name length is more than " + MAX_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
