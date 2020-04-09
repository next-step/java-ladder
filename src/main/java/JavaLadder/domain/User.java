package JavaLadder.domain;

import java.util.Objects;

public class User {
    private static final int LIMIT_NUMBER = 5;
    private String name = "";
    private Point point;

    public User(String name) {
        this(name, 0);
    }

    public User(String name, int point) {
        validateSize(name);
        this.name = name;
        this.point = new Point(point);
    }

    private void validateSize(String name) {
        if (name.length() > LIMIT_NUMBER) {
            throw new IllegalArgumentException("[" + name + "]: " + LIMIT_NUMBER + "자리 이하만 입력가능합니다.");
        }
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

    public Point getPoint() {
        return this.point;
    }

    public boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
