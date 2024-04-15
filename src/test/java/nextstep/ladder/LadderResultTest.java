package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderResultTest {
	@Test
	@DisplayName("LottoResult 객체 생성 테스트")
	void create() {
		final String[] result = {"꽝", "5000", "꽝", "3000"};
		final LadderResult ladderResult = new LadderResult(result);
		assertThat(ladderResult.getResults()).hasSize(4);
	}
}
