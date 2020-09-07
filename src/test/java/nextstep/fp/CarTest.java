package nextstep.fp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 이동() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(() -> true);
        assertThat(actual).isEqualTo(new Car("pobi", 1));
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(()->false);
/*
        new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        });
*/
        assertThat(actual).isEqualTo(new Car("pobi", 0));
    }
}
