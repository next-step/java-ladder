package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.generator.FixedPointGenerator;
import nextstep.ladder.generator.PointGenerator;

class LadderTest {
	@DisplayName("Ladder 생성시에 Point 개수를 검증한다.")
	@Test
	void create() {
		// given
		PointGenerator generator = new FixedPointGenerator();
		int width = 10;
		int height = 10;

		// when
		Ladder ladder = Ladder.create(generator, width, height);

		// then
		assertThat(ladder.getValues().size()).isEqualTo(width * height);
	}

	@DisplayName("point list 가 비어있을 경우 예외 발생")
	@Test
	void validateSize() {
		// given
		List<Point> emptyPoints = Collections.emptyList();

		// when then
		assertAll(
			() -> assertThatIllegalArgumentException()
				.isThrownBy(() -> Ladder.create(null)),
			() -> assertThatIllegalArgumentException()
				.isThrownBy(() -> Ladder.create(emptyPoints))
		);
	}
}
