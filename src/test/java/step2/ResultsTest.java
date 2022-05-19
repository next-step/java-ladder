package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "실행 결과 테스트")
class ResultsTest {

	@Test
	void 문자열_리스트와_플레이어_수를_입력받아서_Wrapping_하는_객체_생성() {
		List<String> input = List.of("1", "2");

		Results actual = new Results(input, input.size());

		assertThat(actual).isEqualTo(new Results(input, input.size()));
	}

	@Test
	void 문자열_리스트가_널이면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Results(null, 1)
		);
	}

	@Test
	void 문자열_리스트_크기와_플레이어_수가_다르면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Results(List.of("1", "2", "3"), 2)
		);
	}

	@Test
	void 문자열_리스트에서_길이가_최댓값_보다_크면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Results(List.of("123456", "2", "3"), 3)
		);
	}
}