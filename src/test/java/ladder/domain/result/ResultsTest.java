package ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ResultsTest {
	@DisplayName(",을 구분으로 한 사용자 이름들을 입력받아 사용자들을 생성한다.")
	@Test
	void createResults() {
		// given
		String resultValues = "꽝,5000,꽝,3000,꽝";
		int namesSize = 5;

		// when
		Results results = Results.createResults(resultValues, namesSize);

		// then
		assertThat(results.getResults()).extracting("value", String.class).contains("꽝", "5000", "꽝", "3000", "꽝");
	}

	@DisplayName("실행 결과들은 사람의 숫자와 같아야 한다.")
	@Test
	void sameResultNumberAndUserNumber() {
		// given
		String resultValues = "꽝,5000,꽝,3000,꽝";
		int namesSize = 4;

		// when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					Results.createResults(resultValues, namesSize);
				}).withMessageMatching("결과 값은 사람의 숫자와 같아야 합니다.");

	}
}
