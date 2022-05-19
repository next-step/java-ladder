package step2.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "가로 라인 테스트")
class LineTest {

	private static final BooleanSupplier TRUE = () -> true;
	private static final BooleanSupplier FALSE = () -> false;

	@Test
	void 플레이어_수와_생성전략을_입력_받아서_가로_라인_생성() {
		Line actual = new Line(4, TRUE);
		Line expect = new Line(4, TRUE);

		assertThat(actual).isEqualTo(expect);
	}

	@ParameterizedTest(name = "{displayName} : {arguments}")
	@NullSource
	void 생성_전략이_널이면_예외(BooleanSupplier supplier) {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Line(5, supplier)
		);
	}

	@Test
	void 플레이어_수와_항상_TRUE_생성전략을_입력_받아서_가로_라인_생성() {
		Line actual = new Line(4, TRUE);
		Line expect = new Line(List.of(Direction.STRAIGHT, Direction.STRAIGHT, Direction.STRAIGHT, Direction.STRAIGHT));

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	void 플레이어_수와_항상_FALSE_생성전략_입력_받아_가로_라인_생성() {
		Line actual = new Line(4, FALSE);
		Line expect = new Line(List.of(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT));

		assertThat(actual).isEqualTo(expect);
	}
}