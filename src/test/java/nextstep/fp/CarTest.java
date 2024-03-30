package nextstep.fp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 이동() {
        Car car = new Car("pobi", 0);
        assertThat(car.move(() -> true)).isEqualTo(new Car("pobi", 1));
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi", 0);
        assertThat(car.move(() -> false)).isEqualTo(new Car("pobi", 0));
    }
}
