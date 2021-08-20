package ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsTest {

	@Test
	@DisplayName("실행결과를 입력하면 실행결과가 생성된다.")
	public void createResult() {
		Results results = new Results("꽝,5000,2000", 3);

		assertThat(results).isEqualTo(new Results("꽝,5000,2000", 3));
		assertThat(results.getResults()).containsExactly(new Result("꽝"), new Result("5000"), new Result("2000"));
	}

	@Test
	@DisplayName("결과값이 빈값이면 예외가 발생된다.")
	public void checkEmptyResult() {
		assertThrows(IllegalArgumentException.class, () ->
			new Results("", 3)
		);
	}

	@Test
	@DisplayName("결과값과 플레이어수가 일치하지 않으면 예외가 발생한다.")
	public void checkResultsLength() {
		assertThrows(IllegalArgumentException.class, () ->
			new Results("aaa,bbb", 3)
		);
	}

	@Test
	@DisplayName("실행결과의 순서를 입력하면 당첨값을 알수 있다.")
	public void findResultOfPerson() {
		Results results = new Results("꽝,5000,2000", 3);

		assertThat(results.findResult(1)).isEqualTo("5000");
	}

}