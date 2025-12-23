package nextstep.fp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 이동() {
        Car car = new Car("pobi", 0);
        Car alwaysMovable = car.move(() -> true);

        assertThat(alwaysMovable).isEqualTo(new Car("pobi", 1));
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi", 0);
        Car neverMovable = car.move(() -> false);

        assertThat(neverMovable).isEqualTo(new Car("pobi", 0));
    }
}
