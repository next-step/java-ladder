package ladder.domain.ladder;

import ladder.domain.Direction;
import ladder.domain.LadderExecutionResult;
import ladder.domain.LadderInput;
import ladder.domain.Participants;
import ladder.domain.line.Line;
import ladder.domain.point.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class LadderTest {

	@Test
	void 사다리를_그리면_수평_수직으로_연결된다() {
		/* 기대하고 있는 사다리 모양
		 * |-----|     |
		 * |-----|     |
		 * |-----|     |
		 */

		// given
		String[] names = new String[]{"사람1", "사람2", "사람3"};

		// when
		Ladder ladder = new Ladder(() -> true, new Participants(names), 3);

		// then
		List<Line> middleLines = ladder.getLines().subList(1, 3);
		for (Line line : middleLines) {
			assertLineHasVerticalAndHorizontalConnection(line);
		}
	}

	@Test
	void 이름을_넣으면_결과가_나온다() {
		/* 기대하고 있는 사다리 모양
		 * A     B     C
		 * |-----|     |
		 * |-----|     |
		 * |-----|     |
		 * 100  200    300
		 * A = 200, B = 100, C = 300
		 */
		// given
		String[] names = new String[]{"사람1", "사람2", "사람3"};
		String[] result = new String[]{"100", "200", "300"};
		Ladder ladder = new Ladder(() -> true, new LadderInput(names, result), 3);

		// when
		String result1 = ladder.getResult("사람1");
		String result2 = ladder.getResult("사람2");
		String result3 = ladder.getResult("사람3");

		// then
		assertThat(result1).isEqualTo("200");
		assertThat(result2).isEqualTo("100");
		assertThat(result3).isEqualTo("300");
	}

	@Test
	void 없는_이름을_넣으면_예외가_나온다() {
		// given
		String[] names = new String[]{"사람1", "사람2", "사람3"};
		String[] result = new String[]{"100", "200", "300"};
		Ladder ladder = new Ladder(() -> true, new LadderInput(names, result), 3);

		// when & then
		assertThatThrownBy(() -> {
			ladder.getResult("사람4");
		})
		.isInstanceOf(IllegalStateException.class);
	}

	@Test
	void 전체_결과를_찾을_수_있다() {
		/* 기대하고 있는 사다리 모양
		 * A     B     C
		 * |-----|     |
		 * |-----|     |
		 * |-----|     |
		 * 100  200    300
		 * A = 200, B = 100, C = 300
		 */
		// given
		String[] names = new String[]{"사람1", "사람2", "사람3"};
		String[] result = new String[]{"100", "200", "300"};
		Ladder ladder = new Ladder(() -> true, new LadderInput(names, result), 3);

		// when
		LadderExecutionResult executionResult = ladder.getAllResult();

		// then
		assertThat(executionResult.getNames()).isEqualTo(Arrays.asList("사람1", "사람2", "사람3"));
		assertThat(executionResult.getExecutionResult("사람1")).isEqualTo("200");
		assertThat(executionResult.getExecutionResult("사람2")).isEqualTo("100");
		assertThat(executionResult.getExecutionResult("사람3")).isEqualTo("300");
	}

	private void assertLineHasVerticalAndHorizontalConnection(Line line) {
		List<Point> points = line.getPoints();

		assertPointHasVerticalConnection(points.get(0));
		assertPointHasVerticalConnection(points.get(1));
		assertPointHasVerticalConnection(points.get(2));

		assertPointHasHorizontalConnection(points.get(0));
		assertPointHasNotHorizontalConnection(points.get(1));
		assertPointHasNotHorizontalConnection(points.get(2));
	}

	private void assertPointHasVerticalConnection(Point point) {
		assertThat(point.hasConnection(Direction.VERTICAL)).isTrue();
	}

	private void assertPointHasHorizontalConnection(Point point) {
		assertThat(point.hasConnection(Direction.HORIZONTAL)).isTrue();
	}

	private void assertPointHasNotHorizontalConnection(Point point) {
		assertThat(point.hasConnection(Direction.HORIZONTAL)).isFalse();
	}

}
