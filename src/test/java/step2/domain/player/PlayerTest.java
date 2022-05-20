package step2.domain.player;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "플레이어 테스트")
class PlayerTest {

	@Test
	void 이름을_입력_받아서_플레이어를_생성한다() {
		String name = "이름";
		assertThat(new Player(name)).isEqualTo(new Player(name));
	}

	@ParameterizedTest(name = "{displayName} : {arguments}")
	@NullAndEmptySource
	void 입력이_널이거나_공백이면_예외(String input) {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Player(input)
		);
	}

	@Test
	void 입력이_5글자_초과하면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Player("다섯글자초과")
		);
	}

	@ParameterizedTest(name = "{displayName} : {0} - {1} => {2}")
	@CsvSource(delimiter = ':', value = {"name:name:true", "name:abcd:false"})
	void 같은_이름의_플레이어인지_반환(String base, String input, boolean result) {

		Player player = new Player(base);

		assertThat(player.hasName(input)).isEqualTo(result);
	}

}