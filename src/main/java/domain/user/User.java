package domain.user;

import java.util.Optional;

public class User {
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 5;

    private String name;

    public User(String name) {
        this.name = Optional.of(name)
                .filter(s -> s.length() >= MIN_SIZE && s.length() <= MAX_SIZE)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return name;
    }
}
