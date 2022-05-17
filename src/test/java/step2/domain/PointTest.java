package step2.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.function.IntSupplier;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "포인트 테스트")
class PointTest {

	private static final IntSupplier ALWAYS_4 = () -> 4;
	private static final IntSupplier ALWAYS_5 = () -> 5;

	@Test
	void 생성_전략을_입력받아서_방향을_Wrapping_하는_객체_생성() {
		assertAll(
			() -> assertThat(Point.firstPointFrom(ALWAYS_4)).isEqualTo(Point.firstPointFrom(ALWAYS_4))
		);

	}

	@Test
	void 방향을_입력받아서_방향을_Wrapping_하는_객체_생성() {
		assertAll(
			() -> assertThat(Point.firstPointFrom(Direction.STRAIGHT)).isEqualTo(
				Point.firstPointFrom(Direction.STRAIGHT))
		);
	}

	@Test
	void 생성_전략이_널이면_예외() {
		IntSupplier supplier = null;
		Direction direction = null;

		SoftAssertions.assertSoftly(softAssertions -> {
			softAssertions.assertThatThrownBy(
				() -> Point.firstPointFrom(supplier)
			).isExactlyInstanceOf(IllegalArgumentException.class);
			softAssertions.assertThatThrownBy(
				() -> Point.firstPointFrom(direction)
			).isExactlyInstanceOf(IllegalArgumentException.class);
		});

	}

	@Test
	void 첫_번째_포인트는_입력_방향이_왼쪽이면_예외() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> Point.firstPointFrom(Direction.LEFT)
		);
	}

	@Test
	void 첫_번째_포인트는_5보다_작으면_직진() {
		assertThat(Point.firstPointFrom(ALWAYS_4)).isEqualTo(Point.firstPointFrom(Direction.STRAIGHT));
	}

	@Test
	void 첫_번째_포인트는_5_이상_이면_오른쪽() {
		assertThat(Point.firstPointFrom(ALWAYS_5)).isEqualTo(Point.firstPointFrom(Direction.RIGHT));
	}

}