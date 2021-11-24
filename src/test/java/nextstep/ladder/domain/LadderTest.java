package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

	/*
	 * 0     1     2     3
	 * |     |     |     |
	 * |     |     |     |
	 * |     |     |     |
	 * |     |     |     |
	 * 0     1     2     3
	 */
	@DisplayName("직선 사다리 이동시에 결과 인덱스를 반환을 검증한다.")
	@ParameterizedTest(name = "{index}. startIndex : {0}")
	@ValueSource(ints = {0, 1, 2, 3})
	void moveWithSimpleLadder(int startIndex) {
		// given
		Generator generator = new FixedFalseGenerator();
		int width = 4;
		int height = 4;

		Ladder ladder = Ladder.initialize(generator, width, height);

		// when
		int movedLastIndex = ladder.move(startIndex);

		// then
		assertThat(movedLastIndex).isEqualTo(startIndex);
	}

	/*
	 * 0     1     2     3
	 * |-----|     |-----|
	 * |     |-----|     |
	 * |-----|     |-----|
	 * |     |-----|     |
	 * 0     1     2     3
	 */
	@DisplayName("직선이 아닌 사다리 이동시에 결과 인덱스를 반환을 검증한다.")
	@ParameterizedTest(name = "{index}. startIndex : {0}, expectedMovedLastIndex : {1}")
	@CsvSource({"0,3", "1,2", "3,0", "2,1"})
	void moveWithComplexLadder(int startIndex, int expectedMovedLastIndex) {
		// given
		Ladder ladder = createLadder();

		// when
		int movedLastIndex = ladder.move(startIndex);

		// then
		assertThat(movedLastIndex).isEqualTo(expectedMovedLastIndex);
	}

	private Ladder createLadder() {
		List<Line> lines = Arrays.asList(
			Line.create(Arrays.asList(
				Point.create(false, true),
				Point.create(true, false),
				Point.create(false, true),
				Point.create(true, false)
			)),
			Line.create(Arrays.asList(
				Point.create(false, false),
				Point.create(false, true),
				Point.create(true, false),
				Point.create(false, false)
			)),
			Line.create(Arrays.asList(
				Point.create(false, true),
				Point.create(true, false),
				Point.create(false, true),
				Point.create(true, false)
			)),
			Line.create(Arrays.asList(
				Point.create(false, false),
				Point.create(false, true),
				Point.create(true, false),
				Point.create(false, false)
			))
		);
		return Ladder.create(lines);
	}
}
