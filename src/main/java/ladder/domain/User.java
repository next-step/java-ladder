package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class User {
    private Name name;
    private Position position;

    public User(String name) {
        this.name = new Name(name);
    }

    public User(String name, int index) {
        this(name);
        this.position = new Position(index, 0);
    }

    public int right(List<Line> lines) {
        Optional.ofNullable(lines.get(position.getRightPosition()));
        return 0;
    }

    public int left(List<Line> lines) {
        Optional.ofNullable(lines.get(position.getRightPosition()));
        return 0;
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

    @Override
    public String toString() {
        return name.toString();
    }

}
