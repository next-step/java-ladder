package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.generator.FixedFalseGenerator;
import nextstep.ladder.generator.Generator;

class LadderTest {
	@DisplayName("Ladder 생성시에 Line 개수를 검증한다.")
	@Test
	void create() {
		// given
		Generator generator = new FixedFalseGenerator();
		int width = 10;
		int height = 10;

		// when
		Ladder ladder = Ladder.initialize(generator, width, height);

		// then
		assertThat(ladder.getLines().size()).isEqualTo(height);
	}

	@DisplayName("line list 가 비어있을 경우 예외 발생")
	@Test
	void validateSize() {
		// given
		List<Line> emptyLines = Collections.emptyList();

		// when then
		assertAll(
			() -> assertThatIllegalArgumentException()
				.isThrownBy(() -> Ladder.create(null)),
			() -> assertThatIllegalArgumentException()
				.isThrownBy(() -> Ladder.create(emptyLines))
		);
	}

}
