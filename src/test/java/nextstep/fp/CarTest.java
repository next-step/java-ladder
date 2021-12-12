package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi", 0);
    }

    @Test
    void 이동() {
        // when
        Car actual = car.move(() -> true);
        // then
        assertThat(actual).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void 정지() {
        // when
        Car actual = car.move(() -> false);
        // then
        assertThat(actual).isEqualTo(new Car("pobi", 0));
    }
}
