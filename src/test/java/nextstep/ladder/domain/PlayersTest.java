package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import nextstep.ladder.exception.PlayerNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

class PlayersTest {

	private Players players = Players.from("pobi,crong,honux,jk");

	@DisplayName("입력 받은 사다리 게임 참가자들의 이름으로 Players 객체를 생성한다.")
	@Test
	void create() {
		assertThat(players).isEqualTo(Players.from("pobi,crong,honux,jk"));
	}

	@DisplayName("입력 받은 사다리 게임 참가자들의 이름은 쉼표(,)를 기준으로 구분한다.")
	@Test
	void splitByComma() {
		assertThat(players.size()).isEqualTo(4);
	}

	@DisplayName("사다리 게임 참가자 리스트에서 특정 참가자의 인덱스를 조회한다.")
	@MethodSource("indexOfArguments")
	@ParameterizedTest
	void indexOf(String targetPlayerName, Integer index) {
		assertThat(players.indexOf(new Player(targetPlayerName))).isEqualTo(index);
	}

	@DisplayName("사다리 게임 참가자 리스트에서 존재하지 않는 참가자의 인덱스 조회 시 예외가 발생한다.")
	@Test
	void playerNotFound() {
		Player targetPlayer = new Player("kim");
		assertThatThrownBy(() -> players.indexOf(targetPlayer))
			.isInstanceOf(PlayerNotFoundException.class);
	}

	private static Stream<Arguments> indexOfArguments() {
		return Stream.of(
			Arguments.of("pobi", 0),
			Arguments.of("crong", 1),
			Arguments.of("honux", 2),
			Arguments.of("jk", 3)
		);
	}

}
