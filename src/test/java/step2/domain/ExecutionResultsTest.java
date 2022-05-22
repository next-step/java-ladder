package step2.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "실행 결과 테스트")
class ExecutionResultsTest {

	@Test
	void 문자열_리스트와_플레이어_수를_입력받아서_Wrapping_하는_객체_생성() {
		List<String> input = List.of("1", "2");

		ExecutionResults actual = new ExecutionResults(input, input.size());

		assertThat(actual).isEqualTo(new ExecutionResults(input, input.size()));
	}

	@Test
	void 문자열_리스트가_널이면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new ExecutionResults(null, 1)
		);
	}

	@Test
	void 문자열_리스트_크기와_플레이어_수가_다르면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new ExecutionResults(List.of("1", "2", "3"), 2)
		);
	}

	@Test
	void 문자열_리스트에서_길이가_최댓값_보다_크면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new ExecutionResults(List.of("123456", "2", "3"), 3)
		);
	}

	@ParameterizedTest(name = "{displayName} : {0} => {1}")
	@CsvSource(
		delimiter = ':',
		value = {
			"0:a",
			"1:b",
			"2:c"
		}
	)
	void 실행결과_인덱스를_받아서_실행결과를_반환(int index, String result) {
		ExecutionResults executionResults = new ExecutionResults(List.of("a", "b", "c"), 3);
		assertThat(executionResults.toResult(index)).isEqualTo(result);
	}

	@Test
	void 실행결과_인덱스가_최솟값보다_작으면_실행_결과_반환_시_예외() {
		ExecutionResults executionResults = new ExecutionResults(List.of("a", "b", "c"), 3);
		assertThatIllegalArgumentException().isThrownBy(
			() -> executionResults.toResult(-1)
		);
	}

	@Test
	void 실행결과_인덱스가_최댓값_보다_크면_실행_결과_반환_시_예외() {
		ExecutionResults executionResults = new ExecutionResults(List.of("a", "b", "c"), 3);
		assertThatIllegalArgumentException().isThrownBy(
			() -> executionResults.toResult(100)
		);
	}
}