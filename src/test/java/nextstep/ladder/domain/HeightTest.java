package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.exception.InvalidHeightException;

class HeightTest {

	@DisplayName("사다리의 높이 값을 포장하는 Height 객체를 생성한다.")
	@Test
	void create() {
		Height height = new Height(1);
		assertThat(height).isEqualTo(new Height(1));
	}

	@DisplayName("사다리의 높이는 1 이상이어야 한다.")
	@Test
	void invalid() {
		assertThatThrownBy(() -> new Height(0))
			.isInstanceOf(InvalidHeightException.class);
	}

}
