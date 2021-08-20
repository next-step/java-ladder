package ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

	@Test
	@DisplayName("결과값을 이력하면 결과값이 생성된다.")
	public void createResult() {
		Result result = new Result("1000");

		assertThat(result).isEqualTo(new Result("1000"));
		assertThat(result.getResult()).isEqualTo("1000");
	}

	@Test
	@DisplayName("결과값이 null 이면 예외가 발생된다.")
	public void checkNull() {
		assertThrows(IllegalArgumentException.class, () ->
			new Result(null)
		);
	}

	@Test
	@DisplayName("결과값이 빈값이면 예외가 발생된다.")
	public void checkEmptyResult() {
		assertThrows(IllegalArgumentException.class, () ->
			new Result("")
		);
	}

	@Test
	@DisplayName("결과값이 5자리 이상이면 예외가 발생된다.")
	public void checkResultLimitLength() {
		assertThrows(IllegalArgumentException.class, () ->
			new Result("100000")
		);
	}

}