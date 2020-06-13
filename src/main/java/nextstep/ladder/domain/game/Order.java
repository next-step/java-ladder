package nextstep.ladder.domain.game;

import java.util.Objects;

public class Order {

    private static final int MINIMUM_ORDER = 0;
    private final int order;

    public Order(int order) {
        this.order = order;
    }

    public static Order from(int order) {
        if (order < MINIMUM_ORDER) {
            throw new IllegalArgumentException("order is less than " + MINIMUM_ORDER);
        }
        return new Order(order);
    }

    public boolean isEqualsOrLessThanMaxPosition(int maxPosition) {
        return order <= maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order1 = (Order) o;
        return order == order1.order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order);
    }
}
