package step2.domain.ladder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.IntSupplier;

import org.assertj.core.api.Assertions;
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

	@Test
	void 방향을_입력받아서_방향을_Wrapping_하는_객체를_캐싱으로_생성() {
		assertAll(
			() -> Assertions.assertThat(Point.from(Direction.STRAIGHT)).isSameAs(
				Point.from(Direction.STRAIGHT))
		);
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

		Point previousRight = Point.from(Direction.RIGHT);

		assertAll(
			() -> assertThat(Point.middlePointFrom(previousRight, ALWAYS_4)).isSameAs(Point.from(Direction.LEFT)),
			() -> assertThat(Point.middlePointFrom(previousRight, ALWAYS_5)).isSameAs(Point.from(Direction.LEFT))
		);
	}

	@Test
	void 중간_포인트는_이전_포인트가_오른쪽이_아니고_5보다_작으면_직진() {

		Point previousLeft = Point.from(Direction.LEFT);
		Point previousStraight = Point.from(Direction.STRAIGHT);

		assertAll(
			() -> assertThat(Point.middlePointFrom(previousLeft, ALWAYS_4)).isSameAs(Point.from(Direction.STRAIGHT)),
			() -> assertThat(Point.middlePointFrom(previousStraight, ALWAYS_4)).isSameAs(Point.from(Direction.STRAIGHT))
		);
	}

	@Test
	void 중간_포인트는_이전_포인트가_오른쪽이_아니고_5보다_크면_오른쪽() {

		Point previousLeft = Point.from(Direction.LEFT);
		Point previousStraight = Point.from(Direction.STRAIGHT);

		assertAll(
			() -> assertThat(Point.middlePointFrom(previousLeft, ALWAYS_5)).isSameAs(Point.from(Direction.RIGHT)),
			() -> assertThat(Point.middlePointFrom(previousStraight, ALWAYS_5)).isSameAs(Point.from(Direction.RIGHT))
		);
	}

}