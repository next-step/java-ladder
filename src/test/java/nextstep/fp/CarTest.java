package nextstep.fp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void 이동() {
        Car car = new Car("pobi", 0);

        Car actual = car.move(() -> true);

        assertThat(actual).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void 정지() {
        Car car = new Car("pobi", 0);

        Car actual = car.move(() -> false);

        assertThat(actual).isEqualTo(new Car("pobi", 0));
    }
}
