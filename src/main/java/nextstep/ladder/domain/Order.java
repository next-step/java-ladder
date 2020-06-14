package nextstep.ladder.domain;


import java.util.Objects;
import java.util.Optional;

public class Order {
    private static final int FIRST_ORDER_NUM = 1;
    public static final Order FIRST_ORDER = Order.of(FIRST_ORDER_NUM);
    private final int num;

    private Order(final int num) {
        this.num = num;
    }

    public static Order of(final int num) {
        return new Order(num);
    }

    public Optional<Order> before() {
        if (num <= FIRST_ORDER_NUM) {
            return Optional.empty();
        }
        return Optional.of(Order.of(this.num - 1));
    }

    public Order next() {
        return Order.of(num + 1);
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
}
