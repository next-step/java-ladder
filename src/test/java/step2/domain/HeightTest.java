package step2.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "사다리 높이 테스트")
class HeightTest {

	@Test
	void 사다리의_높이를_Wrapping_하는_객체를_생성() {
		int input = 1;
		assertThat(new Height(input)).isEqualTo(new Height(input));
	}

	@Test
	void 입력_값이_최소_높이보다_작으면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Height(0)
		);
	}
}