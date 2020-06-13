package nextstep.ladder.domain.user;

import nextstep.ladder.domain.game.Order;

import java.util.Objects;

public class User {

    private final String name;
    private final Order order;

    private User(String name, Order order) {
        this.name = name;
        this.order = order;
    }

    public static User newInstance(String userName, Order order) {
        return new User(userName, order);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(order, user.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, order);
    }
}
