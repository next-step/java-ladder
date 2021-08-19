package ladder.strategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomStrategyTest {

	@Test
	@DisplayName("판단값을 정의하면 그값을 반환한다.")
	public void movableCheck() {
		RandomStrategy result1 = () -> false;

		assertThat(result1.drawLine()).isFalse();

		RandomStrategy result2 = () -> true;

		assertThat(result2.drawLine()).isTrue();
	}
}