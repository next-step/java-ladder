package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExecutionResultTest {
	@DisplayName("ExecutionResult list 가 비어있을 경우 예외 발생")
	@Test
	void validateSize() {
		// given
		List<String> emptyResults = Collections.emptyList();

		// when then
		assertThatIllegalArgumentException()
			.isThrownBy(() -> ExecutionResult.create(emptyResults));
	}

	@DisplayName("인덱스를 입력받아 실행결과를 반환한다.")
	@ParameterizedTest(name = "{index}. index : {0}")
	@ValueSource(ints = {0, 1, 2, 3})
	void getResult(int index) {
		// given
		List<String> results = Arrays.asList("꽝", "5000", "꽝", "3000");
		ExecutionResult executionResult = ExecutionResult.create(results);

		// when
		String result = executionResult.getResult(index);

		// then
		assertThat(result).isEqualTo(results.get(index));
	}
}
