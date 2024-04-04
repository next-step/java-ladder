package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

	@Test
	@DisplayName("라인 그리기 생성 성공 테스트")
	void pointSuccessTest() {
		Point point = new Point(() -> true);
		assertThat(point.isPoint()).isEqualTo(true);
	}

	@Test
	@DisplayName("라인 그리기 실패 성공 테스트")
	void pointFailTest() {
		Point point = new Point(() -> false);
		assertThat(point.isPoint()).isEqualTo(false);
	}

}
