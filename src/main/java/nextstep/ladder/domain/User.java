package nextstep.ladder.domain;

import java.util.Objects;

public class User {

    private String name;
    private int point;

    public User(String name, int point) {
        if("".equals(name)){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return point == user.point &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, point);
    }
}
