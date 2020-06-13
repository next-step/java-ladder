package nextstep.ladder.domain.game;

import java.util.Objects;

public class Order {

    private static final int DEFAULT_ORDER = 0;
    private final int order;

    public Order(int order) {
        this.order = order;
    }

    public static Order from(int order) {
        if (order < DEFAULT_ORDER) {
            throw new IllegalArgumentException("order is more than " + DEFAULT_ORDER);
        }
        return new Order(order);
    }

    public boolean isLessThanMaxPosition(int maxPosition) {
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
