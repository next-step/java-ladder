package nextstep.ladder.domain;

import java.util.Objects;

/**
 * @author han
 */
public class User {

    private static final String ALL = "ALL";
    private final Name name;

    public User(Name name) {
        this.name = name;
    }

    public boolean isAll() {
        return name.getName().equalsIgnoreCase(ALL);
    }

    public String getName() {
        return name.getName();
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
