package nextstep.fp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 이동() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return true;
            }
        });
        assertThat(actual).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void 이동_람다활용_인라인() {
        Car car = new Car("pobi", 0);

        Car actual = car.move(() -> true);

        assertThat(actual).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void 이동_람다활용_변수할당() {
        Car car = new Car("pobi", 0);

        MoveStrategy moveStrategy = () -> true;
        Car actual = car.move(moveStrategy);

        assertThat(actual).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void 이동_람다활용_메서드할당() {
        Car car = new Car("pobi", 0);

        Car actual = car.move(alwaysMove());

        assertThat(actual).isEqualTo(new Car("pobi", 1));
    }

    private MoveStrategy alwaysMove() {
        return () -> true;
    }

    @Test
    public void 정지() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        });
        assertThat(actual).isEqualTo(new Car("pobi", 0));
    }

    @Test
    void 정지_람다활용_인라인() {
        Car car = new Car("pobi", 0);

        Car actual = car.move(() -> false);

        assertThat(actual).isEqualTo(new Car("pobi", 0));
    }

    @Test
    void 정지_람다활용_변수할당() {
        Car car = new Car("pobi", 0);

        MoveStrategy moveStrategy = () -> false;
        Car actual = car.move(moveStrategy);

        assertThat(actual).isEqualTo(new Car("pobi", 0));
    }

    @Test
    void 정지_람다활용_메서드할당() {
        Car car = new Car("pobi", 0);

        Car actual = car.move(neverMove());

        assertThat(actual).isEqualTo(new Car("pobi", 0));
    }

    private MoveStrategy neverMove() {
        return () -> false;
    }
}
