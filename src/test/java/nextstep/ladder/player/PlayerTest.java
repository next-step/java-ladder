package nextstep.ladder.player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class PlayerTest {

	@DisplayName("플레이어를 생성할 때 이름이 null이나 empty면 에러를 반환한다.")
	@NullAndEmptySource
	@ParameterizedTest
	void 이름이_NULL_또는_EMPTY이면_오류를_반환한다(String name) {
		assertThatThrownBy(
			() -> Player.ofPlayer(name)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("플레이어를 생성할 때 이름이 6자를 초과하면 에러를 반환한다.")
	@CsvSource({"abcdef", "123456", "sigridrabbe", "brianthebest", "honuxlovespobi"})
	@ParameterizedTest
	void 플레이어를_생성할_때_이름이_6자를_초과하면_오류를_반환한다(String name) {
		assertThatThrownBy(
			() -> Player.ofPlayer(name)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
