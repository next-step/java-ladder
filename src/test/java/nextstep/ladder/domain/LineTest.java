package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.generator.FixedFalseGenerator;
import nextstep.ladder.generator.RandomGenerator;

class LineTest {
	@DisplayName("Line list 가 비어있을 경우 예외 발생")
	@Test
	void validateSize() {
		// given
		List<Point> emptyPoints = Collections.emptyList();

		// when then
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Line.create(emptyPoints));
	}

	@DisplayName("generator 를 통한 Line 생성 검증")
	@Test
	void createWithGenerator() {
		// given
		RandomGenerator generator = new FixedFalseGenerator();
		int width = 10;

		// when
		Line line = Line.create(generator, width);

		// then
		assertAll(
			() -> assertThat(line).isNotNull(),
			() -> assertThat(line.size()).isEqualTo(width)
		);
	}
}
