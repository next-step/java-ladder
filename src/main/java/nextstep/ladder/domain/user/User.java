package nextstep.ladder.domain.user;

import java.util.Objects;

public class User {

    private final String name;
    private final int order;

    private User(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public static User newInstance(String userName, int order) {
        return new User(userName, order);
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return order == user.order &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, order);
    }
}
