package ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

	@Test
	@DisplayName("실행결과를 입력하면 실행결과가 생성된다.")
	public void createResult() {
		Players players = new Players("aaa,bbb,ccc");
		Result result = new Result("꽝,5000,2000", players);

		assertThat(result).isEqualTo(new Result("꽝,5000,2000", players));
		assertThat(result.getResults()).containsExactly("꽝", "5000", "2000");
	}

	@Test
	@DisplayName("결과값이 빈값이면 예외가 발생된다.")
	public void checkEmptyResult() {
		Players players = new Players("aaa,bbb,ccc");
		assertThrows(IllegalArgumentException.class, () ->
			new Result("", players)
		);
	}

	@Test
	@DisplayName("결과값과 플레이어수가 일치하지 않으면 예외가 발생한다.")
	public void checkResultsLength() {
		Players players = new Players("aaa,bbb,ccc");
		assertThrows(IllegalArgumentException.class, () ->
			new Result("aaa,bbb", players)
		);
	}

	@Test
	@DisplayName("실행결과의 순서를 입력하면 당첨값을 알수 있다.")
	public void findResultOfPerson() {
		Players players = new Players("aaa,bbb,ccc");
		Result result = new Result("꽝,5000,2000", players);

		assertThat(result.findResult(1)).isEqualTo("5000");
	}

}