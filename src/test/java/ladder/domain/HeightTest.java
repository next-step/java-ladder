package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

	@DisplayName("1보다 큰 값으로 높이 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		assertThat(new Height(5)).isEqualTo(new Height(5));
	}

	@DisplayName("1보다 작은 값으로 높이 생성 시, 예외를 던진다.")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Height(0));
	}
}
