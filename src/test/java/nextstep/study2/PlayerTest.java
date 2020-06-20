package nextstep.study2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import study2.domain.Player;
import study2.domain.Players;

class PlayerTest {

	Player player;
	Players players;

	@Test
	@DisplayName("이름 길이 테스트")
	void 이름의_길이가_5자를넘어가면_안된다() {
		assertThatThrownBy(() -> player = new Player("choihyang"))
									.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("플레이어들은 최소 1명이상입니다.")
	@ValueSource(strings = { " ", "" })
	void 플레이어_체크_테스트(String testString) {
		assertThatThrownBy(() -> player = new Player(testString))
									.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> player = new Player(null))
									.isInstanceOf(NullPointerException.class);
	}
}
