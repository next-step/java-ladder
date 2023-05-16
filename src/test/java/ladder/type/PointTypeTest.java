package ladder.type;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTypeTest {

	@DisplayName("left, current를 이용해 좌표 타입을 반환한다.")
	@Test
	void test1() {
		assertThat(PointType.of(false, false)).isEqualTo(PointType.FALSE_FALSE);
		assertThat(PointType.of(true, false)).isEqualTo(PointType.TRUE_FALSE);
		assertThat(PointType.of(false, true)).isEqualTo(PointType.FALSE_TRUE);
	}

	@DisplayName("유효하지 않은 left, current 입력 시, 좌표 타입을 반환한다.")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(() -> PointType.of(true, true));
	}
}
