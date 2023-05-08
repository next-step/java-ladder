package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultsTest {

	@DisplayName("올바른 값으로 실행결과 목록 생성 시, 객체를 반환한다.")
	@Test
	void test1() {
		Results results = new Results("꽝,5000,꽝,3000", new Names("pobi,honux,crong,jk"));
		assertThat(results).isEqualTo(new Results("꽝,5000,꽝,3000", new Names("pobi,honux,crong,jk")));
		assertThat(results.size()).isEqualTo(4);
	}

	@DisplayName("유효하지 않은 값으로 실행결과 목록 생성 시, 예외를 던진다.")
	@Test
	void test2() {
		assertThatIllegalArgumentException().isThrownBy(()
			-> new Results("꽝,5000,꽝,3000", new Names("pobi,honux,crong,jk,yang")));
	}
}
