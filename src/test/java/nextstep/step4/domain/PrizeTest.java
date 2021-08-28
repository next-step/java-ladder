package nextstep.step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

	@DisplayName("사다리 게임의 각 위치별 결과 값을 포장하는 Prize 객체를 생성한다.")
	@Test
	void create() {
		Prize prize = new Prize("꽝");
		assertThat(prize).isEqualTo(new Prize("꽝"));
	}
}
