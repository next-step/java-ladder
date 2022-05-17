package step2.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "플레이어 테스트")
class PlayerTest {

	@Test
	void 이름을_입력_받아서_플레이어를_생성한다() {
		String name = "이름";
		assertThat(new Player(name)).isEqualTo(new Player(name));
	}

}