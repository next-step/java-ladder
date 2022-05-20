package step2.domain.player;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "플레이어 일급 컬렉션 테스트")
class PlayersTest {

	@Test
	void 문자열_리스트를_입력받아_플레이어_일급컬렉션_생성() {
		List<String> input = List.of("aaa", "bbb", "ccc", "ddd");
		assertThat(new Players(input)).isEqualTo(new Players(input));
	}

	@ParameterizedTest(name = "{displayName} : {arguments}")
	@NullSource
	void 입력_값이_널이거나_공백인_경우_예외(List<String> input) {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Players(input)
		);
	}

	@Test
	void 중복된_이름이_있는_경우_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Players(List.of("aaa", "aaa", "ccc", "ddd"))
		);
	}

	@Test
	void 플레이어의_수가_두_명_보다_작으면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Players(List.of("aaa"))
		);
	}

	@ParameterizedTest
	@CsvSource(
		delimiter = ':',
		value = {
			"aaa:0",
			"bbb:1",
			"ccc:2",
			"ddd:3",
		}
	)
	void 이름을_입력받아서_플레이어의_출발_인덱스를_반환(String playerName, int index) {
		Players players = new Players(List.of("aaa", "bbb", "ccc", "ddd"));

		assertThat(players.findIndexByName(playerName)).isEqualTo(index);
	}

	@Test
	void 입력된_널_일때_출발_인덱스를_찾으면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Players(List.of("aaa", "bbb", "ccc", "ddd")).findIndexByName(null)
		);
	}

	@Test
	void 입력된_이름이_존재하지_않을_때_출발_인덱스를_찾으면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Players(List.of("aaa", "bbb", "ccc", "ddd")).findIndexByName("이상한 이름")
		);
	}
}