package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by seungwoo.song on 2022-11-07
 */
class LadderGameResultTest {

	@Test
	void 생성() {
		assertThat(LadderGameResult.of("꽝")).isEqualTo(LadderGameResult.of("꽝"));
		assertThat(LadderGameResult.of("100")).isEqualTo(LadderGameResult.of("100"));
	}

	@Test
	void 생성_실패() {
		assertThatIllegalArgumentException().isThrownBy(() -> LadderGameResult.of("gg"));
	}
}