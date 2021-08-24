package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

	@DisplayName("사다리 게임 실행 결과를 저장한다.")
	@Test
	void result() {
		Result result = new Result(Players.from("pobi,crong,honux,jk"));
		result.put(0, 2);
		result.put(1, 1);
		result.put(2, 0);
		result.put(3, 3);

		assertThat(result.of(new Player("pobi"))).isEqualTo(2);
		assertThat(result.of(new Player("crong"))).isEqualTo(1);
		assertThat(result.of(new Player("honux"))).isZero();
		assertThat(result.of(new Player("jk"))).isEqualTo(3);
	}

}