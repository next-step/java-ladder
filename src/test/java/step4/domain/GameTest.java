package step4.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameTest {
	private static Game game;

	@BeforeAll
	static void set() {
		game = new Game(new String[] {"dami", "corgi", "hong", "mong"}, new String[]{"10", "0", "1000", "5000"});
	}

	@DisplayName(value = "게임 결과 입력 개수 초과 테스트")
	@Test
	void gameResultCountOverException() {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> new Game(
						new String[] {"dami", "corgi", "hong", "mong"},
						new String[] {"1000", "5000", "100", "꽝", "꽝"}))
				.withMessage("실행 결과 수는 입력한 참여자 수와 같아야 합니다.");
	}

	@DisplayName(value = "결과 조회 시 게임 참여자 이름을 입력하지 않은 경우 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"dam", "aaa", "1234"})
	void gameUserNameException(String name) {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> game.getUserResult(name))
				.withMessage("입력하신 이름은 참여자 목록에 없습니다.");
	}

}
