package nextstep.ladder.entity;

import nextstep.ladder.entity.exception.IllegalUserNameException;

import java.util.Optional;

public class User {

    private final String name;

    public User(String username) {
        String validUsername = Optional.ofNullable(username)
                .filter(name -> !name.isEmpty())
                .filter(name -> name.length() <= 5)
                .orElseThrow(() -> new IllegalUserNameException(username));
        this.name = validUsername;
    }

    public String getName() {
        return name;
    }
}
