package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created by seungwoo.song on 2022-10-24
 */
class LadderGameResultsTest {

	@Test
	void 생성() {
		assertThat(LadderGameResults.of(List.of("꽝","1000"))).isEqualTo(LadderGameResults.of(List.of("꽝","1000")));
	}

	@Test
	void 결과값_조회_성공() {
		LadderGameResults ladderGameResults = LadderGameResults.of(List.of("꽝", "1000"));

		assertThat(ladderGameResults.get(new Person("test", 1))).isEqualTo(LadderGameResult.of("1000"));
	}

	@Test
	void 결과값_조회_실패() {
		LadderGameResults ladderGameResults = LadderGameResults.of(List.of("꽝", "1000"));

		assertThatIllegalArgumentException().isThrownBy(() -> ladderGameResults.get(new Person("test", 3)));
	}
}