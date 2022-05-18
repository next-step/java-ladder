package step2.domain.ladder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.IntSupplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "포인트 테스트")
class PointTest {

	private static final IntSupplier ALWAYS_4 = () -> 4;
	private static final IntSupplier ALWAYS_5 = () -> 5;

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
	void 첫_번째_포인트는_5보다_작으면_직진() {
		assertThat(Point.firstPointFrom(ALWAYS_4)).isSameAs(Point.from(Direction.STRAIGHT));
	}

	@Test
	void 첫_번째_포인트는_5_이상_이면_오른쪽() {
		assertThat(Point.firstPointFrom(ALWAYS_5)).isSameAs(Point.from(Direction.RIGHT));
	}

	@Test
	void 중간_포인트는_이전_포인트가_오른쪽이면_왼쪽() {
		assertAll(
			() -> assertThat(Point.middlePointFrom(PREVIOUS_RIGHT, ALWAYS_4)).isSameAs(Point.from(Direction.LEFT)),
			() -> assertThat(Point.middlePointFrom(PREVIOUS_RIGHT, ALWAYS_5)).isSameAs(Point.from(Direction.LEFT))
		);
	}

	@Test
	void 중간_포인트는_이전_포인트가_오른쪽이_아니고_5보다_작으면_직진() {
		assertAll(
			() -> assertThat(Point.middlePointFrom(PREVIOUS_LEFT, ALWAYS_4)).isSameAs(Point.from(Direction.STRAIGHT)),
			() -> assertThat(Point.middlePointFrom(PREVIOUS_STRAIGHT, ALWAYS_4)).isSameAs(
				Point.from(Direction.STRAIGHT))
		);
	}

	@Test
	void 중간_포인트는_이전_포인트가_오른쪽이_아니고_5보다_크면_오른쪽() {
		assertAll(
			() -> assertThat(Point.middlePointFrom(PREVIOUS_LEFT, ALWAYS_5)).isSameAs(Point.from(Direction.RIGHT)),
			() -> assertThat(Point.middlePointFrom(PREVIOUS_STRAIGHT, ALWAYS_5)).isSameAs(Point.from(Direction.RIGHT))
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

}