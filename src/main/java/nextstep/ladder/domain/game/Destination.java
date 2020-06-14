package nextstep.ladder.domain.game;

import java.util.Objects;

public class Destination {

    private Order order;
    private Result result;

    private Destination(Order order, Result result) {
        this.order = order;
        this.result = result;
    }

    public static Destination of(Order order, Result result) {
        return new Destination(order, result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return order.equals(that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, result);
    }
}
