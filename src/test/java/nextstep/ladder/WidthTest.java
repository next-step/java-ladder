package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Width;

public class WidthTest {

	@DisplayName("2명 미만일 시 사다리 게임을 진행할 수 없다.")
	@Test
	void validate_is_over_min() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Width(1))
			.withMessage("사다리 게임 참여인원은 2명보다 커야합니다.");
	}
}
