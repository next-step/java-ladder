package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

	@DisplayName("높이를 생성한다.")
	@Test
	void test1() {
		assertThat(new Height(5)).isEqualTo(new Height(5));
	}

	@DisplayName("1보다 작은 값으로 높이를 생성할 시, 예외를 던진다.")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Height(0));
	}
}
