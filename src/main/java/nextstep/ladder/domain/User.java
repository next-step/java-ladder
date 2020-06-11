package nextstep.ladder.domain;

public class User {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public User(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("`name` length is must under " + MAX_LENGTH);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
