package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Height;

public class HeightTest {
	@DisplayName("사다리의 높이는 1보다 커야합니다.")
	@Test
	void validate_is_over_min() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new Height(0))
			.withMessage("사다리의 높이는 1보다 커야합니다.");
	}
}
