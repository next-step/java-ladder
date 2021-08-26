package nextstep.step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.step4.exception.InvalidHeightException;

class HeightTest {

	@DisplayName("사다리 높이 값을 포장하는 Height 객체를 생성한다.")
	@Test
	void create() {
		Height height = new Height(2);
		assertThat(height).isEqualTo(new Height(2));
	}

	@DisplayName("사다리 높이가 1 미만일 경우, InvalidHeightException 예외가 발생한다.")
	@Test
	void invalid() {
		assertThatThrownBy(() -> new Height(0))
			.isInstanceOf(InvalidHeightException.class);
	}

}
