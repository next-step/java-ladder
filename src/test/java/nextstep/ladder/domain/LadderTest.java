package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

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
		assertThat(ladder.values().size()).isEqualTo(width * height);
	}
}
