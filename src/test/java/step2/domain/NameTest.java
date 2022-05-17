package step2.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "이름 테스트")
class NameTest {

	@Test
	void 사용자_이름을_입력받아서_Wrapping_하는_객체를_생성() {
		String name = "이름";
		assertThat(new Name(name)).isEqualTo(new Name(name));
	}

	@ParameterizedTest(name = "{displayName} : {arguments}")
	@NullAndEmptySource
	void 입력이_널이거나_공백이면_예외(String input) {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Name(input)
		);
	}

	@Test
	void 입력이_5글자_초과하면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Name("다섯글자초과")
		);
	}

}
