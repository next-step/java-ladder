package nextstep.ladder.domain.player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

	@DisplayName("플레이어를 생성할 때 이름이 null이나 empty면 에러를 반환한다.")
	@NullAndEmptySource
	@ParameterizedTest
	void 이름이_NULL_또는_EMPTY이면_오류를_반환한다(String name) {
		assertThatThrownBy(
			() -> Player.ofNameAndPosition(name, 0)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("플레이어를 생성할 때 이름이 6자를 초과하면 에러를 반환한다.")
	@CsvSource({"abcdef", "123456", "sigridrabbe", "brianthebest", "honuxlovespobi"})
	@ParameterizedTest
	void 플레이어를_생성할_때_이름이_6자를_초과하면_오류를_반환한다(String name) {
		assertThatThrownBy(
			() -> Player.ofNameAndPosition(name, 0)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("플레이어 생성 시에 위치를 입력한다. 이에 따라 정상적으로 위치가 초기화된다.")
	@ValueSource(ints = {2, 3, 4, 5, 6, 7, 8})
	@ParameterizedTest
	void 생성한_플레이어의_위치가_출력된다(int position) {
		String name = "brian";
		assertThat(Player.ofNameAndPosition(name, position).getPosition())
			.isEqualTo(position);
	}
}
