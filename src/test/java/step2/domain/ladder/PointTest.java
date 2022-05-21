package step2.domain.ladder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "포인트 테스트")
class PointTest {

	private static final BooleanSupplier FALSE = () -> false;
	private static final BooleanSupplier TRUE = () -> true;

	private static final Point PREVIOUS_LEFT = Point.from(Direction.LEFT);
	private static final Point PREVIOUS_STRAIGHT = Point.from(Direction.STRAIGHT);
	private static final Point PREVIOUS_RIGHT = Point.from(Direction.RIGHT);

	@Test
	void 방향을_입력받아서_방향을_Wrapping_하는_객체를_캐싱으로_생성() {
		assertThat(Point.from(Direction.STRAIGHT)).isSameAs(Point.from(Direction.STRAIGHT));
	}

	@ParameterizedTest(name = "{displayName} : {arguments}")
	@NullSource
	void 생성_전략이_널이면_예외(Direction direction) {
		assertThatIllegalArgumentException().isThrownBy(
			() -> Point.from(direction)
		);
	}

	@Test
	void 첫_번째_포인트는_true_이면_직진() {
		assertThat(Point.firstPointFrom(TRUE)).isSameAs(Point.from(Direction.STRAIGHT));
	}

	@Test
	void 첫_번째_포인트는_false_이면_오른쪽() {
		assertThat(Point.firstPointFrom(FALSE)).isSameAs(Point.from(Direction.RIGHT));
	}

	@Test
	void 중간_포인트는_이전_포인트가_오른쪽이면_왼쪽() {
		assertAll(
			() -> assertThat(Point.middlePointFrom(PREVIOUS_RIGHT, FALSE)).isSameAs(Point.from(Direction.LEFT)),
			() -> assertThat(Point.middlePointFrom(PREVIOUS_RIGHT, TRUE)).isSameAs(Point.from(Direction.LEFT))
		);
	}

	@Test
	void 중간_포인트는_이전_포인트가_오른쪽이_아니고_true_이면_직진() {
		assertAll(
			() -> assertThat(Point.middlePointFrom(PREVIOUS_LEFT, TRUE)).isSameAs(Point.from(Direction.STRAIGHT)),
			() -> assertThat(Point.middlePointFrom(PREVIOUS_STRAIGHT, TRUE)).isSameAs(
				Point.from(Direction.STRAIGHT))
		);
	}

	@Test
	void 중간_포인트는_이전_포인트가_오른쪽이_아니고_false_오른쪽() {
		assertAll(
			() -> assertThat(Point.middlePointFrom(PREVIOUS_LEFT, FALSE)).isSameAs(Point.from(Direction.RIGHT)),
			() -> assertThat(Point.middlePointFrom(PREVIOUS_STRAIGHT, FALSE)).isSameAs(Point.from(Direction.RIGHT))
		);
	}

	@Test
	void 마지막_포인트는_이전_포인트가_오른쪽이면_왼쪽() {
		assertThat(Point.lastPointFrom(PREVIOUS_RIGHT)).isSameAs(Point.from(Direction.LEFT));
	}

	@Test
	void 마지막_포인트는_이전_포인트가_오른쪽이_아니면_직진() {
		assertAll(
			() -> assertThat(Point.lastPointFrom(PREVIOUS_LEFT)).isSameAs(Point.from(Direction.STRAIGHT)),
			() -> assertThat(Point.lastPointFrom(PREVIOUS_STRAIGHT)).isSameAs(Point.from(Direction.STRAIGHT))
		);
	}

	@ParameterizedTest(name = "{displayName} : {0} : {1} => {2}")
	@CsvSource(
		delimiter = ':',
		value = {
			"LEFT:5:4",
			"STRAIGHT:5:5",
			"RIGHT:5:6"
		}
	)
	void 현재_인덱스를_입력받아_현재_포인트의_방향을_기준으로_다음_인덱스를_반환(Direction direction, int currentIndex, int nextIndex) {

		Point currentPoint = Point.from(direction);

		assertThat(currentPoint.nextLineIndex(currentIndex)).isEqualTo(nextIndex);
	}

}