package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.InputResult;

public class InputResultTest {

	@Test
	@DisplayName("실행 결과 객체 생성 테스트 : 정상케이스")
	void inputResultTest() {
		InputResult inputResult = new InputResult("꽝,5000,꽝,3000", 4);
		assertThat(inputResult.getInputResults()).containsExactly("꽝", "5000", "꽝", "3000");
	}

	@Test
	@DisplayName("실행 결과 객체 생성 테스트 : 비정상케이스")
	void inputResultInvalidTest() {
		assertThatThrownBy(() -> {
			new InputResult("꽝,5000,꽝,3000", 5);
		}).hasMessage("결과값의 갯수와 플레이어 수가 일치해야 합니다.");
	}
}
