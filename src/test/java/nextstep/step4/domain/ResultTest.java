package nextstep.step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

	@DisplayName("사다리 게임의 결과 값들을 저장한다.")
	@Test
	void create() {
		Result result = new Result();
		result.add(new Player("pobi"), new Prize("꽝"));
		result.add(new Player("crong"), new Prize("1000"));
		result.add(new Player("honux"), new Prize("5000"));
		result.add(new Player("jk"), new Prize("10000"));

		assertThat(result.of(new Player("pobi"))).isEqualTo(new Prize("꽝"));
		assertThat(result.of(new Player("crong"))).isEqualTo(new Prize("1000"));
		assertThat(result.of(new Player("honux"))).isEqualTo(new Prize("5000"));
		assertThat(result.of(new Player("jk"))).isEqualTo(new Prize("10000"));
	}
}
