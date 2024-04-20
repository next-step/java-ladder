package nextstep.ladder.domain.user;

import java.util.Objects;
import java.util.Optional;

public class UserName {

    private static final int NAME_LENGTH_MAX = 5;
    String name;

    private UserName(String name) {
        validName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static UserName of(String name) {
        return new UserName(name);
    }

    private void validName(String name) {
        Optional.of(name)
            .filter(nm -> nm.length() <= NAME_LENGTH_MAX)
            .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserName userName = (UserName) o;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
