package nextstep.ladder.entity;

import nextstep.ladder.entity.exception.IllegalUserNameException;

import java.util.Objects;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
