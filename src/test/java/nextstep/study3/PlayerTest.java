package nextstep.study3;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import study3.domain.Player;
import study3.domain.Players;

class PlayerTest {

	private Player player;
	private Players players;

	@Test
	@DisplayName("이름 길이 테스트")
	void 이름의_길이가_5자를넘어가면_안된다() {
		assertThatThrownBy(() -> player = new Player("choihyang"))
									.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("이름의 validation테스트")
	@MethodSource("blankStrings")
	void 플레이어_체크_테스트(String testString) {
		assertThatThrownBy(() -> player = new Player(testString))
									.isInstanceOf(IllegalArgumentException.class);
	}
	
	static Stream<String> blankStrings() {
		return Stream.of("", " ", null, "asfasdfasdafsd");
	}
}
