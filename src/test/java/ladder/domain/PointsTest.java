package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointsTest {

	@DisplayName("좌표를 등록한다.")
	@Test
	void test1() {
		Points points = new Points(true, false, true, false);
		assertThat(points).isEqualTo(new Points(true, false, true, false));
	}

	@DisplayName("좌표 등록 예외 케이스 - 인접 좌표 채움")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Points(true, true, false, false));
	}
}
