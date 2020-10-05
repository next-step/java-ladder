package nextstep.ladder.domain;

import java.util.Objects;

public class User implements Comparable<User> {
    private final int order;
    private final String name;
    private Result result;

    public User(int order, String name) {
        checkNameNotOver5(name);
        this.order = order;
        this.name = name;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.name.length(), o.name.length());
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public Result getResult() {

        return result;
    }

    private void checkNameNotOver5(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5를 넘지 않아야 합니다.");
        }
    }
}
