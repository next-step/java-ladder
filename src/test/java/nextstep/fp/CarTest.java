package nextstep.fp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 이동() {
        final Car car = new Car("pobi", 0);
        final Car actual = car.move(() -> true);

        assertThat(actual).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void 정지() {
        final Car car = new Car("pobi", 0);
        final Car actual = car.move(() -> false);

        assertThat(actual).isEqualTo(new Car("pobi", 0));
    }
}
