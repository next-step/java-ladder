package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {

	@DisplayName("올바른 값으로 실행결과 목록 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		Results results = new Results("꽝,5000,꽝,3000");
		assertThat(results).isEqualTo(new Results("꽝,5000,꽝,3000"));
		assertThat(results.size()).isEqualTo(4);
	}
}
