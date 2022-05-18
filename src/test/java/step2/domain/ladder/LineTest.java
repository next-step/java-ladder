package step2.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.function.IntSupplier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "가로 라인 테스트")
class LineTest {

	private static final IntSupplier ALWAYS_4 = () -> 4;
	private static final IntSupplier ALWAYS_5 = () -> 5;

	@Test
	void 플레이어_수와_생성전략을_입력_받아서_가로_라인_생성() {
		Line actual = new Line(4, ALWAYS_4);
		Line expect = new Line(4, ALWAYS_4);

		assertThat(actual).isEqualTo(expect);
	}

	@ParameterizedTest(name = "{displayName} : {arguments}")
	@NullSource
	void 생성_전략이_널이면_예외(IntSupplier supplier) {
		assertThatIllegalArgumentException().isThrownBy(
			() -> new Line(5, supplier)
		);
	}

	@Test
	void 플레이어_수와_항상_5_보다_작은_생성전략을_입력_받아서_가로_라인_생성() {
		Line actual = new Line(4, ALWAYS_4);
		Line expect = new Line(List.of(Direction.STRAIGHT, Direction.STRAIGHT, Direction.STRAIGHT, Direction.STRAIGHT));

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	void 플레이어_수와_5_보다_큰_생성전략을_입력_받아_가로_라인_생성() {
		Line actual = new Line(4, ALWAYS_5);
		Line expect = new Line(List.of(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT));

		assertThat(actual).isEqualTo(expect);
	}
}