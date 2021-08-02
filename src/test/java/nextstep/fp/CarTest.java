package nextstep.fp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final MoveStrategy POSITIVE_MOVE_STRATEGY = () -> true;
    private static final MoveStrategy DONT_MOVE_STRATEGY = () -> false;

    @Test
    public void 이동() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(POSITIVE_MOVE_STRATEGY);
        assertThat(actual).isEqualTo(new Car("pobi", 1));
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(DONT_MOVE_STRATEGY);
        assertThat(actual).isEqualTo(new Car("pobi", 0));
    }
}
