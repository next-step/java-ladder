package nextstep.fp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

  @Test
  public void 이동() {
    //given
    Car car = new Car("pobi", 0);

    //when
    Car actual = car.move(() -> true);

    //ten
    assertThat(actual).isEqualTo(new Car("pobi", 1));
  }

  @Test
  public void 정지() {
    //given
    Car car = new Car("pobi", 0);

    //when
    Car actual = car.move(() -> false);

    //ten
    assertThat(actual).isEqualTo(new Car("pobi", 0));
  }
}
