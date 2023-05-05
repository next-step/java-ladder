package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointsTest {

	@DisplayName("좌표를 등록한다.")
	@Test
	void test1() {
		Points points = new Points(Arrays.asList(true, false, true, false));
		assertThat(points).isEqualTo(new Points(Arrays.asList(true, false, true, false)));
	}

	@DisplayName("좌표 등록 예외 케이스 - 인접 좌표 채움")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Points(Arrays.asList(true, true, false, false)));
	}
}
