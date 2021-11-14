package nextstep.fp;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
	@DisplayName("이동한다.")
	@Test
	void move() {
		Car car = new Car("pobi", 0);
		Car actual = car.move(() -> true);
		assertThat(actual).isEqualTo(new Car("pobi", 1));
	}

	@DisplayName("이동하지 않는다.")
	@Test
	void stop() {
		Car car = new Car("pobi", 0);
		Car actual = car.move(() -> false);
		assertThat(actual).isEqualTo(new Car("pobi", 0));
	}
}
