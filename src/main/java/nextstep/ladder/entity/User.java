package nextstep.ladder.entity;

import nextstep.ladder.entity.exception.IllegalUserNameException;

import java.util.Optional;

public class User {

    private String name;

    public User(String username) {
        this.name = Optional.ofNullable(username)
                .filter(name -> !name.isEmpty())
                .filter(name -> name.length() <= 5)
                .orElseThrow(() -> new IllegalUserNameException(username));
    }

    public String getName() {
        return String.format("%5s", name);
    }

}
