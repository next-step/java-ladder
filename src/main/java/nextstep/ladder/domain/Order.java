package nextstep.ladder.domain;


import java.util.Objects;
import java.util.Optional;

public class Order {
    private static final int FIRST_ORDER_NUM = 1;
    private final int num;

    private Order(final int num) {
        this.num = num;
    }

    public static Order of(final int num) {
        return new Order(num);
    }

    public Order next() {
        return Order.of(this.num + 1);
    }

    public Optional<Order> before() {
        if (num <= FIRST_ORDER_NUM) {
            return Optional.empty();
        }
        return Optional.of(Order.of(this.num - 1));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Order order = (Order) o;
        return num == order.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
